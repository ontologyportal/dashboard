package com.articulate.dashboard.servlet;

/**
 * This code is copyright Infosys Ltd 2017.
 * @author mohit.gupta
 *
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.articulate.dashboard.utils.ConfigManager;
import com.articulate.dashboard.utils.QAExecutor;
import com.articulate.dashboard.utils.RecordsManager;

/**
 * Servlet implementation class DashBoard
 */
@WebServlet(description = "Displays Graph of Dashboard", urlPatterns = { "/dashboard" })
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashBoard() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			ConfigManager.initialize();
			QAExecutor.startTimer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RecordsManager.readRecords();
		List<String> charts = RecordsManager.getChartJsons();
		request.setAttribute("charts", charts);
		request.setAttribute("chartNames", RecordsManager.getAllChartNames());
		request.setAttribute("numCharts", charts.size());
		request.getRequestDispatcher("/jsp/dash.jsp").forward(request, response);
	}

}