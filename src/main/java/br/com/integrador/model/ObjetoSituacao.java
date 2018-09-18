package br.com.integrador.model;

public enum ObjetoSituacao {

    TRIAGEM("triagem"),
    SAIU_PARA_ENTREGA("saiu para entrega"),
    ENTREGUE("entregue"),
    NAO_ENTTREGUE("não entregue");

    private String descricao;

    ObjetoSituacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
