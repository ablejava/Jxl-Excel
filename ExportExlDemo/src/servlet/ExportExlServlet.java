package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import entity.Member;

public class ExportExlServlet extends HttpServlet {

	private WritableWorkbook wwb = null;

	private WritableSheet sheet = null;

	private WritableSheet sheetk = null;

	private WritableSheet sheeth = null;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkOrgId = null;
		String orgName = "XX单位";
		try {
			exportCheckOrgMember(checkOrgId, orgName, response);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		exportExcel(response, wwb, orgName + "人员明细表");
	}
	
	/**
	 * 导出数据处理
	 * @param checkOrgId
	 * @param orgName
	 * @param response
	 * @throws IOException
	 * @throws RowsExceededException
	 * @throws WriteException
	 */
	
	private void exportCheckOrgMember(String checkOrgId,String orgName, HttpServletResponse response)
			throws IOException, RowsExceededException, WriteException {
		//此处listMember需要从数据库中取值
		List<Member> listMember = new ArrayList<Member>();
		Member member1 = new Member("str", "str", "str", "str", "str", "str", "str", "str", "str", "str", "隶书", "str", new Date(), new Date());
		listMember.add(member1);
		listMember.add(member1);
		listMember.add(member1);
		System.out.println(listMember.size()+"***");
		
		
		response.setContentType("application/ms-excel");
		String sheetName_ = orgName + "人员明细表";//文件名==》XX人员明细表
		String sheetName = new String(sheetName_.getBytes(),"iso8859-1");
		  
		response.addHeader("Content-Disposition", "attachment;filename="+ sheetName + ".xls");

		OutputStream os = response.getOutputStream();
		wwb = Workbook.createWorkbook(os);
		wwb.setProtected(false);

		//EXECL中的一个sheet
		sheetk = wwb.createSheet("人员明细", 0);

		//============设置execl表的一些属性===========
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 13,WritableFont.BOLD, false);
		WritableCellFormat wcf = new WritableCellFormat(wf);
		WritableFont wf1 = new WritableFont(WritableFont.ARIAL, 13,WritableFont.NO_BOLD, false);
		WritableCellFormat wcf1 = new WritableCellFormat(wf1);
		wcf.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
		wcf1.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);
		wcf1.setVerticalAlignment(VerticalAlignment.CENTRE);
		//============设置execl表的一些属性======END=====
		
		/*sheetk.mergeCells(0, 0, 9, 0);
		sheetk.addCell(new Label(0, 0, "人员明细表《这是合并的单元格》", wcf));
		
		//添加单元格  new Label(列位置，行位置，单元格内容，WritableCellFormat对象)
		//此处第二个参数1，代表第二行，上面合并的单元格是第一行
		sheetk.addCell(new Label(0, 1, "序号", wcf));
		sheetk.addCell(new Label(1, 1, "姓名", wcf));
		sheetk.addCell(new Label(2, 1, "性别", wcf));
		sheetk.addCell(new Label(3, 1, "身份证号", wcf));
		sheetk.addCell(new Label(4, 1, "学历", wcf));
		sheetk.addCell(new Label(5, 1, "专业", wcf));
		sheetk.addCell(new Label(6, 1, "职称", wcf));
		sheetk.addCell(new Label(7, 1, "职务", wcf));
		sheetk.addCell(new Label(8, 1, "角色", wcf));
		sheetk.addCell(new Label(9, 1, "备注", wcf));*/
		
		String[] title = {"编号", "姓名", "性别", "身份证号", "学历", "专业", "职称", "职务", "角色", "备注"};
		Label label;
		for (int i = 0; i < title.length; i++) {
			// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
			// 在Label对象的子对象中指明单元格的位置和内容
			//label = new Label(i, 0, title[i]);
			label = new Label(i, 0, title[i], Excel.getHeader());
			// 将定义好的单元格添加到工作表中
			sheetk.addCell(label);
		}
		// 设置字体
					
		jxl.write.WritableFont wfont = new jxl.write.WritableFont(WritableFont.createFont("隶书"), 20);
		WritableCellFormat font = new WritableCellFormat(wfont);
		//循环数据，将数据填充到单元格内
		int t = 1;
		for (Member member:listMember) {
			sheetk.addCell(new Label(0, t, t+"", wcf1));
			sheetk.addCell(new Label(1, t, member.getMemberName(), wcf1));
			sheetk.addCell(new Label(2, t, member.getSex(), wcf1));
			sheetk.addCell(new Label(3, t, member.getCardId(), wcf1));
			sheetk.addCell(new Label(4, t, member.getAcademic(), wcf1));
			sheetk.addCell(new Label(5, t, member.getSpecial(), wcf1));
			sheetk.addCell(new Label(6, t, member.getTitle(), wcf1));
			sheetk.addCell(new Label(7, t, member.getDuty(), wcf1));
			sheetk.addCell(new Label(8, t, member.getRole(), wcf1));
			sheetk.addCell(new Label(9, t, member.getMemo(), font));
			t++;
		}
	}
	
	/*
	 * 执行导出操作
	 */
	private void exportExcel(HttpServletResponse response,
			WritableWorkbook retValue, String filename) {
		response.setContentType("application/ms-excel");
		/*response.addHeader("Content-Disposition", "attachment; filename="
				+ filename + ".xls");*/
		try {
			retValue.write();
			retValue.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	

}
