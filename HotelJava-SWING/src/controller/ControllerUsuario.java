package controller;

import java.util.ArrayList;
import java.util.List;

import Hotel.Usuario;

public class ControllerUsuario {
	public static boolean validaLogin(Usuario usuario) {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("admin", "123"));
		
		for (Usuario item : usuarios) {
			if (item.getLogin().equals(usuario.getLogin())
					&& item.getSenha().equals(usuario.getSenha())) {
				return true;
			}
		}
		
		return false;
	}
}
