/**
 * Classe contendo atributos refente ao objeto unidade e os métodos getter e setter para tratamento dos dados inseridos pelo usuário
 * **/
public class Unidades {

    private Integer uni_cod;
    private String uni_medida;

    /**
     * construtor da classe recebendo os atributos da unidade como parâmetro
     **/
    public Unidades(Integer uni_cod, String uni_medida) {
        setUni_cod(uni_cod);
        setUni_medida(uni_medida);
    }

    public Integer getUni_cod() {
        return uni_cod;
    }

    public void setUni_cod(Integer uni_cod) {
        this.uni_cod = uni_cod;
    }

    public String getUni_medida() {
        return uni_medida;
    }

    public void setUni_medida(String uni_medida) {
        this.uni_medida = uni_medida;
    }

    /**
     *Método responsável por exibir os dados do objeto unidades
     * **/
    @Override
    public String toString() {
        return "Código da unidade: " + uni_cod +
                "\nunidade de medida: " + uni_medida + "\n****************************\n";
    }
}

