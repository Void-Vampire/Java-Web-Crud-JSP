package com.crudJSP.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudJSP.bean.Usuario;

public class UsuarioDAO {
	
	public static Connection getConexao() throws ClassNotFoundException{
        Connection conn = null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjspjava?user=root&password=");
            System.out.println("Conectado com sucesso");
        } catch(SQLException e){
            System.out.println("Erro ao conectar");
        }
        return conn;
    }
	
	// Delete User
	
	public static int deletarUsuario(Usuario u) {
int status = 0;
		
		try {
			Connection con = getConexao();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuario WHERE id=?");
			ps.setInt(1, u.getId());
			status=ps.executeUpdate();
		}catch(Exception e){
            System.out.println("Erro ao conectar");
        }	
		return status;
	}
	
	// Save User
	
	public static int salvarUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConexao();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuario (nome, password, email, sexo, pais, idade) VALUES (?,?,?,?,?,?)");	
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			ps.setInt(6, u.getIdade());
			status = ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
	}
		return status;
	}
	
	// Form ID
	
	public static Usuario getRegistroById(int id) {
		Usuario usuario = null;
		
		try {
			Connection con = getConexao();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				usuario.setIdade(rs.getInt("idade"));
			} 
		} catch(Exception e) {
			System.out.println(e);
	}
		return usuario;
	}
	
	// Edit User
	
	public static int updateUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConexao();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuario SET nome=?, " + 
			"password=?, email=?, sexo=?, pais=?, idade=? WHERE id=?");
			
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			ps.setInt(6, u.getIdade());
			ps.setInt(7, u.getId());
			status = ps.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);	
		}
		return status;
	}
	
	
	// View User
	
	public static List<Usuario> getAllUsuarios(){
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConexao();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				usuario.setIdade(rs.getInt("idade"));
				list.add(usuario);
				
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	
	
}


