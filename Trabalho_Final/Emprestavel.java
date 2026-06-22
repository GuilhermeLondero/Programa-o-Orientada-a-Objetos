// contrato de tudo que pode ser emprestado na biblioteca
public interface Emprestavel {
    boolean isDisponivel();
    void marcarComoEmprestado();
    void marcarComoDisponivel();
    double getMultaPorDia();
}