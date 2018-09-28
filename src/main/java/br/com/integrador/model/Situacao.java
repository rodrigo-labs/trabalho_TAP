package br.com.integrador.model;

public enum Situacao {

    TRIAGEM("triagem"),
    CARREGADO("carregado"),
    SAIU_PARA_ENTREGA("saiu para entrega"),
    ENTREGUE("entregue"),
    NAO_ENTTREGUE("não entregue");

    private String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
