package org.demo.springboot.base.utils;

import org.apache.ibatis.session.RowBounds;
import org.demo.springboot.base.pojo.Page;

public class PageMethod {

	public static RowBounds getRowBounds(Page page) {
		return new RowBounds(page.getOffset(), page.getPageSize());
	}
	
}
