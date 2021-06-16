package com.dev.projetoAPI.config.validation;

public class FormErroDto {
	
	private String campo;
	private String erro;
	
	public FormErroDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

	
}
