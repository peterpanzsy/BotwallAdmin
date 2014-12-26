package cn.edu.xjtu.manage.action;

import java.util.List;
import java.util.Set;

import cn.edu.xjtu.manage.business.ControlIp;
import cn.edu.xjtu.manage.dao.ControlIpDao;

import com.opensymphony.xwork2.ActionSupport;

public class ControlIpAction  extends ActionSupport{
	String ip;
	String remark;
	List<ControlIp> dataList;
	private int page;
	private int records;
	private int rows;
	private int rowNum;
	private int total;
	private String sidx;
	private String sord;
	private int id;
	private List<Integer> ids;

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	String re;
	
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSidx() {
		return sidx;
	}

	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	
	public String getRe() {
		return re;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public int getRowNum() {
		return rowNum;

	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getPage(){
		return page;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<ControlIp> getDataList() {
		return dataList;
	}

	public int getRecords() {
		return records;
	}


	public String execute(){
		
		return "SUCCESS";
	}


	private Object[] rowData;
	public Object[] getRowData() {
		return rowData;
	}
	public void setRowData(Object[] rowData) {
		this.rowData = rowData;
	}
	
	public String list(){		

		ControlIpDao dao=new ControlIpDao();
		
		dataList=dao.getControlIpList();
	
		records=dao.getCountControlIp();

		if(records!=0&&rows!=0){
		total=records/rows;
			if(records%rows!=0){
				total++;
			}
		}
		return "SUCCESS";
	}
	
	public String add(){

		ControlIpDao dao=new ControlIpDao();		
		int result=dao.addControlIp(ip,remark);
		dao.close();
		return "SUCCESS";
	}
	
	public String delete(){
		ControlIpDao dao=new ControlIpDao();
		if(!ids.isEmpty()){
			for(int id:ids){
				dao.deleteControlIp(id);
			}
		}
		dao.close();
		return "SUCCESS";
	}
	
}
