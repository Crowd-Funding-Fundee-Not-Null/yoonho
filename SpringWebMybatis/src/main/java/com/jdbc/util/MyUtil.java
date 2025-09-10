package com.jdbc.util;

public class MyUtil {

	//전체 페이지 갯수
	public int getPagecount(int numPerPage, int dataCount) {
		
		int pageCount = 0;
		
		pageCount = dataCount / numPerPage;
		
		if (dataCount % numPerPage != 0) {
			pageCount++;
		}
		
		return pageCount;
	}
	
	
	//페이징 처리 메소드
	public String pageIndexList(int currentPage, int totalPage, int numPerBlock, String listUrl) {
		
		//int numPerBlock :	◀이전 6 7 8 9 10 다음▶
		int currentPageSetup;	//◀이전 을 누르면 이동할 pageNum 의 값
		int page;
		
		StringBuffer sb = new StringBuffer();
		
		if (currentPage==0 || totalPage==0) {
			return "";
		}
		
		//list.jsp
		//list.jsp?searchKey=name&searchValue=suzi
		
		if (listUrl.indexOf("?")!=-1) { //검색했을 때
			listUrl += "&";
		} else {
			listUrl += "?";
		}
		
		//◀이전 의 pageNum
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if (currentPage % numPerBlock == 0) {
			currentPageSetup -= numPerBlock;
		}
		
		//◀이전
		if (totalPage>numPerBlock && currentPageSetup>0) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup + "\">◀이전</a>&nbsp;");
			// <a href="list.jsp?pageNum=5">◀이전</a>&nbsp;
			
		}
		
		
		
		
		//바로가기 페이지
		page = currentPageSetup + 1;
		
		while (page<=totalPage && page<=(currentPageSetup+numPerBlock)) {
			
			if (page==currentPage) {
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
			} else {
				sb.append("<a href=\"" + listUrl + "pageNum=" + page +"\">" + page + "</a>&nbsp;");
			}
			
			page++;
			
		}
		
		
		//다음▶
		if (totalPage - currentPageSetup > numPerBlock) {

			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">다음▶</a>&nbsp;");
			// <a href="list.jsp?pageNum=11">다음▶</a>&nbsp;

		}
		
		
		return sb.toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
