package com.example.studentnotes.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class CorsFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2=(HttpServletRequest)request;
		HttpServletResponse response2=(HttpServletResponse)response;
		response2.setHeader("Access-Control-Allow-Origin", request2.getHeader("*"));//һ��дip�˿ں�
		response2.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
		response2.setHeader("Access-Control-Max-Age","5000");//Ԥ�ڼ��Ļ���ʱ�䡣
		response2.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Headers', 'Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild");
		
		response2.setHeader("Access-Control-Allow-Credentials", "true"); //��������Я��ƾ֤����Я��Cookie
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
