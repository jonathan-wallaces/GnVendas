package com.gnvendas.gnVendas.util;

import java.util.ArrayList;
import java.util.List;

import com.gnvendas.gnVendas.entities.Produto;

public class Util {
	public static List<Produto> cart;
	static {
		cart = new ArrayList<Produto>();
	}

}
