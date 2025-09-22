package com.fundee.util;

public class MyUtil {

	//��ü ������ ����
	public int getPagecount(int numPerPage, int dataCount) {
		
		int pageCount = 0;
		
		pageCount = dataCount / numPerPage;
		
		if (dataCount % numPerPage != 0) {
			pageCount++;
		}
		
		return pageCount;
	}
	
	
	//����¡ ó�� �޼ҵ�
	public String pageIndexList(int currentPage, int totalPage, int numPerBlock, String listUrl) {
		
		//int numPerBlock :	������ 6 7 8 9 10 ������
		int currentPageSetup;	//������ �� ������ �̵��� pageNum �� ��
		int page;
		
		StringBuffer sb = new StringBuffer();
		
		if (currentPage==0 || totalPage==0) {
			return "";
		}
		
		//list.jsp
		//list.jsp?searchKey=name&searchValue=suzi
		
		if (listUrl.indexOf("?")!=-1) { //�˻����� ��
			listUrl += "&";
		} else {
			listUrl += "?";
		}
		
		//������ �� pageNum
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if (currentPage % numPerBlock == 0) {
			currentPageSetup -= numPerBlock;
		}
		
		sb.append("<ul class=\"pagination justify-content-center\" >");
		
		
		
		//������
		if (totalPage>numPerBlock && currentPageSetup>0) {
			sb.append("<li class=\"page-item\">");
			sb.append("<a class=\"page-link\" href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">��</a>&nbsp;");
			// <a href="list.jsp?pageNum=5">������</a>&nbsp;
			sb.append("</li>");
		}
		
		
		
		
		//�ٷΰ��� ������
		page = currentPageSetup + 1;
		
		while (page<=totalPage && page<=(currentPageSetup+numPerBlock)) {
			
			if (page==currentPage) {
				sb.append("<li class=\"page-item active\" aria-current=\"page\">");
				sb.append("<span class=\"page-link\">"+page);
				sb.append("<span class=\"sr-only\">(current)</span></span>");
				sb.append("</li>");
			} else {
				sb.append("<li class=\"page-item\">");
				sb.append("<a class=\"page-link\" href=\"" + listUrl + "pageNum=" + page +"\">" + page + "</a>&nbsp;");
				sb.append("</li>");
			}
			
			page++;
			
		}
		
		
		//������
		if (totalPage - currentPageSetup > numPerBlock) {
			sb.append("<li class=\"page-item\">");
			sb.append("<a class=\"page-link\" href=\"" + listUrl + "pageNum=" + page + "\">��</a>&nbsp;");
			// <a href="list.jsp?pageNum=11">������</a>&nbsp;
			sb.append("</li>");
		}
		
		
		sb.append("</ul>");
		
		
		return sb.toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
