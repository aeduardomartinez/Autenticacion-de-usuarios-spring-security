package com.autenticacion.user;

import com.autenticacion.user.model.PermisosUser;
import com.autenticacion.user.model.RoleEnum;
import com.autenticacion.user.model.Roles;
import com.autenticacion.user.model.Usuario;
import com.autenticacion.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			/* Create PERMISSIONS */
			PermisosUser createPermission = PermisosUser.builder()
					.name("CREATE")
					.build();

			PermisosUser readPermission = PermisosUser.builder()
					.name("READ")
					.build();

			PermisosUser updatePermission = PermisosUser.builder()
					.name("UPDATE")
					.build();

			PermisosUser deletePermission = PermisosUser.builder()
					.name("DELETE")
					.build();

			/* Create ROLES */
			Roles roleAdmin = Roles.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permisoList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			Roles roleUser = Roles.builder()
					.roleEnum(RoleEnum.USER)
					.permisoList(Set.of(createPermission, readPermission))
					.build();

			Roles roleInvited = Roles.builder()
					.roleEnum(RoleEnum.INVITADO)
					.permisoList(Set.of(readPermission))
					.build();

			Roles roleDeveloper = Roles.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permisoList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			/* CREATE USERS */
					Usuario userSantiago = Usuario.builder()
							.username("santiago")
							.password("1234")
							.isEnabled(true)
							.accountNoExpired(true)
							.accountNoLocked(true)
							.credentialNoExpired(true)
							.roles(Set.of(roleAdmin))
							.build();

					Usuario userDaniel = Usuario.builder()
							.username("daniel")
							.password("1234")
							.isEnabled(true)
							.accountNoExpired(true)
							.accountNoLocked(true)
							.credentialNoExpired(true)
							.roles(Set.of(roleUser))
							.build();

					Usuario userAndrea = Usuario.builder()
							.username("andrea")
							.password("1234")
							.isEnabled(true)
							.accountNoExpired(true)
							.accountNoLocked(true)
							.credentialNoExpired(true)
							.roles(Set.of(roleInvited))
							.build();

					Usuario userAnyi = Usuario.builder()
							.username("anyi")
							.password("1234")
							.isEnabled(true)
							.accountNoExpired(true)
							.accountNoLocked(true)
							.credentialNoExpired(true)
							.roles(Set.of(roleDeveloper))
							.build();

					userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi));

				};
	}
}