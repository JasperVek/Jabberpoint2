package io;

import java.io.IOException;

import model.Presentation;

public class HTMLWriter implements IWriter {
	private Presentation p;
	private String fn;

	public HTMLWriter(Presentation p, String fn) {
		this.p = p;
		this.fn = fn;
	}

	@Override
	public void write() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void read() throws IOException {
		// Do nothing

	}
}
