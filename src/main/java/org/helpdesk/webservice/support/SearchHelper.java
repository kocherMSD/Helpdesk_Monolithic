package org.helpdesk.webservice.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.helpdesk.db.dao.SearchDao;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.MessageBoard;
import org.helpdesk.db.model.ProductEntity;
import org.helpdesk.db.model.TicketRequestEntity;
import org.helpdesk.webservice.request.MessageRequest;
import org.helpdesk.webservice.response.MessageViewAllResponse;
import org.helpdesk.webservice.response.ProductDetailsResponse;
import org.helpdesk.webservice.response.ProductFamilyDetails;
import org.helpdesk.webservice.response.SearchResponse;
import org.helpdesk.webservice.response.ViewAllTicketResponse;
import org.helpdesk.webservice.response.ViewTicketResponse;

public class SearchHelper {

	ExecutorService executorService = Executors.newScheduledThreadPool(10);
	private SearchDao dao = null;
	
	public void setDao(SearchDao dao) {
		this.dao = dao;
	}

	public SearchDao getDao() {
		return dao;
	}

	public SearchResponse search(final String query) {
		SearchResponse searchResponse = new SearchResponse();

		try {

			Set<Callable<List<? extends BaseBusinessObject>>> callables = new HashSet<Callable<List<? extends BaseBusinessObject>>>();
			

			callables.add(new Callable<List<? extends BaseBusinessObject>>() {
				public List<? extends BaseBusinessObject> call() throws Exception {
					return dao.getAllMessage(query);
				}
			});
			callables.add(new Callable<List<? extends BaseBusinessObject>>() {
				public List<? extends BaseBusinessObject> call() throws Exception {
					return dao.findUserTicket(query);
				}
			});
			callables.add(new Callable<List<? extends BaseBusinessObject>>() {
				public List<? extends BaseBusinessObject> call() throws Exception {
					return dao.getProduct(query);
				}
			});
			

			List<Future<List<? extends BaseBusinessObject>>> futures = executorService.invokeAll(callables);

			for (Future<List<? extends BaseBusinessObject>> future : futures) {
				while(!future.isDone())
				{
					
				}
				if (future.isDone()&&future.get().size() > 0) {
					if ((future.get().get(0)) instanceof MessageBoard) {
						MessageViewAllResponse response = new MessageViewAllResponse();
						List<MessageRequest> msgList = new ArrayList<MessageRequest>();
						List<? extends BaseBusinessObject> messages = future.get();
						for (BaseBusinessObject bo : messages) {
							MessageRequest msg = new MessageRequest();
							msg.setTitle(((MessageBoard) bo).getTitle());
							msg.setDate(((MessageBoard) bo).getCreated_date());
							msgList.add(msg);
						}
						response.setMessages(msgList);
						searchResponse.setMessages(response);

					}
					if ((future.get().get(0)) instanceof TicketRequestEntity) {
						List<? extends BaseBusinessObject> ticketRequestEntities = future.get();
						ViewAllTicketResponse res = new ViewAllTicketResponse();
						// TODO Auto-generated method stub
						List<ViewTicketResponse> ticketRequestsWS = new ArrayList<ViewTicketResponse>();
						for (BaseBusinessObject ticketRequestEntity : ticketRequestEntities) {
							ViewTicketResponse trw = new ViewTicketResponse();
							trw.setCustomer_name(((TicketRequestEntity) ticketRequestEntity).getCustomer_name());
							trw.setDescriptiveSummary(
									((TicketRequestEntity) ticketRequestEntity).getDescriptiveSummary());
							trw.setEmailAddress(((TicketRequestEntity) ticketRequestEntity).getEmailAddress());
							trw.setIssueScope(((TicketRequestEntity) ticketRequestEntity).getIssueScope());
							trw.setIssueType(((TicketRequestEntity) ticketRequestEntity).getIssueType());
							trw.setOutage(((TicketRequestEntity) ticketRequestEntity).getOutage());
							trw.setProduct(((TicketRequestEntity) ticketRequestEntity).getProduct());
							trw.setProductFamily(((TicketRequestEntity) ticketRequestEntity).getProductFamily());
							trw.setSeverityId(((TicketRequestEntity) ticketRequestEntity).getSeverityId());
							trw.setStatusName(((TicketRequestEntity) ticketRequestEntity).getStatusName());
							trw.setSummary(((TicketRequestEntity) ticketRequestEntity).getSummary());
							trw.setUserId(((TicketRequestEntity) ticketRequestEntity).getUserId());
							ticketRequestsWS.add(trw);

						}
						res.setViewTicketResponses(ticketRequestsWS);
						searchResponse.setTickets(res);

					}
					if ((future.get().get(0)) instanceof ProductEntity) {
						List<? extends BaseBusinessObject> products = future.get();
						ProductFamilyDetails pf=new ProductFamilyDetails();
						ProductDetailsResponse productDetail=new ProductDetailsResponse();
						List<ProductFamilyDetails> productsList= new ArrayList<ProductFamilyDetails>();

						for (BaseBusinessObject bo : products) {
							 pf=new ProductFamilyDetails();
							 pf.setProductFamily( ((ProductEntity) bo ) .getProductfamily() );
							 pf.setTechnologySolution(((ProductEntity) bo ) .getSolutiontechnology() );
							 pf.setProductId(((ProductEntity) bo ) .getPid());
							 productsList.add(pf);
						}
						productDetail.setProductFamilyListList(productsList);

						searchResponse.setCatalogue(productDetail);
					}


				}
			}
			executorService.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchResponse;

	}

}
