/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Clay
 */
public class Funcionario {
    private int codigo;
    private String cpf;
    private int cargaHoraria;
    private String nome;
    private BigDecimal salario;
    private Date dataAdmissao;
    
    public Funcionario() {}

    public Funcionario(String nome, String cpf, BigDecimal salario, Date dataAdmissao, int codigo, int cargaHoraria) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.cargaHoraria = cargaHoraria;
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public Funcionario( String nome, String cpf, BigDecimal salario, Date dataAdmissao, int cargaHoraria) {
        this.cpf = cpf;
        this.cargaHoraria = cargaHoraria;
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
    
}
