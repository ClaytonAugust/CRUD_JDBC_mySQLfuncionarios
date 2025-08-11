/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistência;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import modelo.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Clay
 */
public class JDBCFuncionarios {
    
    Connection conexão;

    public JDBCFuncionarios(Connection conexão) {
        this.conexão = conexão;
    }
    
    public void inserirFuncionario(Funcionario f){
        String sql = "insert into funcionarios(nome, cpf, salario, data_admissao, carga_horaria) values(?, ?, ?, ?, ?)";
        PreparedStatement ps;
        
        try{
            ps = this.conexão.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setString(2, f.getCpf());
            ps.setBigDecimal(3, f.getSalario());
            ps.setDate(4, new java.sql.Date(f.getDataAdmissao().getTime()));
            ps.setInt(5, f.getCargaHoraria());
            ps.execute();
        }catch(SQLException e) {
        e.printStackTrace();
        }
    }
    
    public void atualizarFuncionario(Funcionario f) {
        String sql = "UPDATE Funcionarios SET nome = ?, salario = ?, data_admissao = ?, carga_horaria = ? WHERE cpf = ?";

        try {
            PreparedStatement ps = conexão.prepareStatement(sql);
            ps.setString(1, f.getNome());
            ps.setBigDecimal(2, f.getSalario());
            ps.setDate(3, new java.sql.Date(f.getDataAdmissao().getTime()));
            ps.setInt(4, f.getCargaHoraria());
            ps.setString(5, f.getCpf());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public ArrayList<Funcionario> listarFuncionário(){
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String sql = "select * from funcionarios";
        
        try {
            Statement declaração = conexão.createStatement();
            ResultSet resposta = declaração.executeQuery(sql);
            
            while(resposta.next()){
                
                int codigo = resposta.getInt("codigo");
                String nome = resposta.getString("nome");
                String cpf = resposta.getString("cpf");
                BigDecimal salario = resposta.getBigDecimal("salario");
                Date dataAdmissao = resposta.getDate("data_admissao");
                int cargaHoraria = resposta.getInt("carga_horaria");
                
                Funcionario f = new Funcionario(nome, cpf, salario, dataAdmissao, codigo, cargaHoraria);
                funcionarios.add(f);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return funcionarios;
    }
    
    public void apagarTudo() {
        String sql = "delete from funcionarios";
        
        PreparedStatement ps;
        try{
            ps = this.conexão.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
