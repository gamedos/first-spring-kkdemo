package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.commons.codec.binary.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.quya.core.utils.JStringUtils;
import com.quya.core.utils.JacksonUtils;
import com.quya.core.utils.MysqlUtils;
import com.webapp.entry.KkTopic;

import ch.qos.logback.core.util.StringCollectionUtil;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		PrintWriter _out = response.getWriter();
		
		String url = "http://www.kkmh.com/web/topic/{id}";RestTemplate restTemplate = new RestTemplate();
		String html = (String) restTemplate.getForObject(url, String.class, new Object[] { 782 });
		// 分析 html 获取
		// 1, 评论 key2key
		String pinglun = JStringUtils.key2key(html, "<em>评论:</em>", "</span>");
		System.out.println("pinglun => " + pinglun);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//
		response.setCharacterEncoding("utf-8");
		PrintWriter _out = response.getWriter();

		int prepage = 0;
		int nextpage = 0;
		int curpage = 0;
		//
		
		String page = request.getParameter("page");
		String tags = request.getParameter("tags");
		if(tags==null){
			tags = "0";
		}
		if(page!=null){
			curpage = Integer.parseInt(page);
			prepage = (curpage>0)?(curpage-1):0;
			nextpage = curpage + 1;
		}
		//
		String url = "http://www.kkmh.com/web/tags/{tags}?count={count}&page={page}";
		//
		// Connection conn = Jsoup.connect(url);
		// conn.data("count", "20");
		// conn.data("page", "1");
		// Document doc = conn.get();
		// System.out.println(doc.outerHtml());
		// _out.println(doc.outerHtml());

		//
		RestTemplate restTemplate = new RestTemplate();
		String json = (String) restTemplate.getForObject(url, String.class, new Object[] { tags, "5", curpage });
		Map obj = (Map) JacksonUtils.toObject(json, Object.class);
		String message = (String) obj.get("message");
		if ("OK".equals(message)) {
			Map data = (Map) obj.get("data");
			List<Map> topics = (List<Map>) data.get("topics");
			List<KkTopic> kkTopics = new ArrayList<KkTopic>();
			if (topics.size() > 0) {
//				List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
				
				for (Map m : topics) {
					kkTopics.add(new KkTopic(m));
					Map<String,Object> datas = new HashMap<String,Object>();

						
						datas.put("id",  ((Integer) m.get("id")).intValue());
						datas.put("labelId", ((Integer) m.get("label_id")).intValue());
						datas.put("title",  (String) m.get("title"));
						datas.put("description",  (String) m.get("description"));
//						list.add(datas);
						MysqlUtils.insert("tbTopics", datas);	
				}
//				MysqlUtils.insert("tbTopics", list);
			}
			//
			request.setAttribute("kkTopics", kkTopics);
			request.setAttribute("prepage", prepage);
			request.setAttribute("curpage", curpage);
			request.setAttribute("nextpage", nextpage);
			request.setAttribute("tags", tags);
			request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
			return;
		} else {
			_out.println("读取文件失败啦");
		}

		// String html =
		// (String)restTemplate.getForObject("http://www.kkmh.com/web/topic/400/",String.class);
		// _out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
