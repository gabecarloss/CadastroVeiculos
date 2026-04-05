class Veiculo {
    private String nome;
    private String marca;
    private String placa;
    //Pesquisei como deixar os dados inseridos mais seguros e decidi usar private

    public Veiculo(String nome, String marca, String placa){
        this.nome = nome;
        this.marca = marca;
        this.placa = placa;
    }

    public String getNome(){
        return nome;
    }

    public String getMarca(){
        return marca;
    }

    public String getPlaca() {
        return placa;
    }

    public String toString(){
        return "Nome: " + nome + " / " + "Marca: " + marca + " / " + "Placa: " + placa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}