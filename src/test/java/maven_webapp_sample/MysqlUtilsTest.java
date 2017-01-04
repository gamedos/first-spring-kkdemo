<<<<<<< HEAD
package maven_webapp_sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.quya.core.utils.JSQLHelper;
import com.quya.core.utils.MysqlUtils;

public class MysqlUtilsTest {

	@Test
	public void insertDataTest(){
		Map<String,Object> datas = new HashMap<String,Object>();
		datas.put("id", 1);
		datas.put("title", "aaa");
		datas.put("description", "description");
		MysqlUtils.insert("tbTopics", datas);
	}
	@Test
	public void insertSomeTest(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0;i<5;i++){
			Map<String,Object> datas = new HashMap<String,Object>();
			datas.put("id", 7+i);
			datas.put("title", "aaa");
			datas.put("description", "description");
			list.add(datas);
		}
		MysqlUtils.insert("tbTopics", list);
	}
	
	@Test
	public void updateTest(){

		Map<String,Object> datas = new HashMap<String,Object>();
		datas.put("title", " title2 ");
		datas.put("gid", " gid + 1");
		MysqlUtils.update("tbTopics", datas , " id = 1222");
	}
	
	@Test
	public void deleteTest(){
		MysqlUtils.delete("tbTopics", "1 = 1");
	}

	@Test
	public void getOneTest(){
		Integer data = MysqlUtils.oneIntegerValue("tbTopics", "gid", " id = 7");
		String data2 = MysqlUtils.oneStringValue("tbTopics", "gid", " id = 17");
		
		System.out.println(" data is = " + data);
		System.out.println(" data2 is = " + data2);
	}
	
	@Test
	public void getSomeFieldsValuesTest(){

		Map<String , Object> retdata = MysqlUtils.someFieldsValues("tbTopics", new String[]{"id","gid","title"}, " id = 7");
		System.out.println(retdata);
		
		Map<String , Object> retdata2 = MysqlUtils.someFieldsValues("tbTopics", " id, gid , title , orderNum", " id = 7");
		System.out.println(retdata2);
	}
	
	@Test
	public void getAllTest() throws SQLException{
		JSQLHelper sqlHelper = new JSQLHelper("tbTopics", 2);
		
		
		
		sqlHelper.setFields(" id , gid , title , orderNum ");
		sqlHelper.addCondition(" id > 5 ").addCondition(" id < 19");
		sqlHelper.addOrderBy("id", "DESC").addOrderBy("orderNUM", "ASC");
		//sqlHelper.setLimit(1, 2);
		
		
		//  ::先执行::总数量和当前也设置
		String sqlT = sqlHelper.getSqlTotal();
		Integer totalCount = MysqlUtils.getTotalCount(sqlT);
		//-- 分页
		sqlHelper.getPage().setTotalNumber(totalCount);
		sqlHelper.getPage().setCurrentPage(2);
		
		//
		String sqlQ = sqlHelper.getSqlQuery();
		//
		System.out.println("sqlQ "+sqlQ);
		System.out.println("sqlT "+sqlT);
		System.out.println("page "+sqlHelper.getPage().toString());
		//
		List<Map<String,Object>> rs = MysqlUtils.getAll(sqlQ);
		
		for(int i=0,l=rs.size();i<l;i++){
			
		}
		System.out.println("totalCount = " + totalCount);
		System.out.println(rs);
		
		//
	}
}
=======
package maven_webapp_sample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.quya.core.utils.JSQLHelper;
import com.quya.core.utils.MysqlUtils;

public class MysqlUtilsTest {

	@Test
	public void insertDataTest(){
		Map<String,Object> datas = new HashMap<String,Object>();
		datas.put("id", 1);
		datas.put("title", "aaa");
		datas.put("description", "description");
		MysqlUtils.insert("tbTopics", datas);
	}
	@Test
	public void insertSomeTest(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0;i<5;i++){
			Map<String,Object> datas = new HashMap<String,Object>();
			datas.put("id", 7+i);
			datas.put("title", "aaa");
			datas.put("description", "description");
			list.add(datas);
		}
		MysqlUtils.insert("tbTopics", list);
	}
	
	@Test
	public void updateTest(){

		Map<String,Object> datas = new HashMap<String,Object>();
		datas.put("title", " title2 ");
		datas.put("gid", " gid + 1");
		MysqlUtils.update("tbTopics", datas , " id = 1222");
	}
	
	@Test
	public void deleteTest(){
		MysqlUtils.delete("tbTopics", "1 = 1");
	}

	@Test
	public void getOneTest(){
		Integer data = MysqlUtils.oneIntegerValue("tbTopics", "gid", " id = 7");
		String data2 = MysqlUtils.oneStringValue("tbTopics", "gid", " id = 17");
		
		System.out.println(" data is = " + data);
		System.out.println(" data2 is = " + data2);
	}
	
	@Test
	public void getSomeFieldsValuesTest(){

		Map<String , Object> retdata = MysqlUtils.someFieldsValues("tbTopics", new String[]{"id","gid","title"}, " id = 7");
		System.out.println(retdata);
		
		Map<String , Object> retdata2 = MysqlUtils.someFieldsValues("tbTopics", " id, gid , title , orderNum", " id = 7");
		System.out.println(retdata2);
	}
	
	@Test
	public void getAllTest() throws SQLException{
		JSQLHelper sqlHelper = new JSQLHelper("tbTopics", 2);
		
		
		
		sqlHelper.setFields(" id , gid , title , orderNum ");
		sqlHelper.addCondition(" id > 5 ").addCondition(" id < 19");
		sqlHelper.addOrderBy("id", "DESC").addOrderBy("orderNUM", "ASC");
		//sqlHelper.setLimit(1, 2);
		
		
		//  ::先执行::总数量和当前也设置
		String sqlT = sqlHelper.getSqlTotal();
		Integer totalCount = MysqlUtils.getTotalCount(sqlT);
		//-- 分页
		sqlHelper.getPage().setTotalNumber(totalCount);
		sqlHelper.getPage().setCurrentPage(2);
		
		//
		String sqlQ = sqlHelper.getSqlQuery();
		//
		System.out.println("sqlQ "+sqlQ);
		System.out.println("sqlT "+sqlT);
		System.out.println("page "+sqlHelper.getPage().toString());
		//
		List<Map<String,Object>> rs = MysqlUtils.getAll(sqlQ);
		
		for(int i=0,l=rs.size();i<l;i++){
			
		}
		System.out.println("totalCount = " + totalCount);
		System.out.println(rs);
		
		//
	}
}
>>>>>>> branch 'master' of https://github.com/gamedos/first-spring-kkdemo.git
