package ci.digitalacademy.monetab.monetabwebSpring;

import ci.digitalacademy.monetab.monetabwebSpring.models.*;
import ci.digitalacademy.monetab.monetabwebSpring.service.AdressService;
import ci.digitalacademy.monetab.monetabwebSpring.service.StudentService;
import ci.digitalacademy.monetab.monetabwebSpring.service.TeacherService;
import ci.digitalacademy.monetab.monetabwebSpring.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@SpringBootApplication
public class MonetabwebSpringApplication implements CommandLineRunner {

	private StudentService studentService;
	private AdressService adressService;
	private TeacherService teacherService;
	private UserService userService;



	public static void main(String[] args) {
		SpringApplication.run(MonetabwebSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		/*Adress addressStudent1 = new Adress();
		addressStudent1 .setCity("Abidjan");
		addressStudent1 .setCountry("Atos");
		addressStudent1 .setStreet("Rue 17");
		adressService.save(addressStudent1 );


		Adress addressStudent2 = new Adress();
		addressStudent2.setCity("Isia");
		addressStudent2.setCountry("Isia compagny");
		addressStudent2.setStreet("Rue 25");
		adressService.save(addressStudent2);*/

		Student student1 = new Student();
		student1.setMatricule("AUHGF-KK");
		student1.setMatricule("TYDYT");
		student1.setNom("Bakayoko");
		student1.setPrenom("Koffi");
		student1.setMail("KOFFI@gmail.com");

	//	student1.setAdress(addressStudent1);


		Student student2 = new Student();
		student2.setMatricule("AUHGF-KK");
		student2.setMatricule("TYDscwcYT");
		student2.setNom("Bakayxscsoko");
		student2.setPrenom("xdvd");
		student2.setMail("KOFFxccI@gmail.com");
		//student2.setAdress(addressStudent2);

		studentService.save(student1);
		studentService.save(student2);




		/*Adress addressTeacher1 = new Adress();
		addressTeacher1 .setCity("Abidjan");
		addressTeacher1 .setCountry("Atos");
		addressTeacher1 .setStreet("Rue 17");
		adressService.save(addressTeacher1 );


		Adress addressTeacher2 = new Adress();
		addressTeacher2.setCity("Belvil");
		addressTeacher2.setCountry("Belvil compagny");
		addressTeacher2.setStreet("Rue 45");
		adressService.save(addressTeacher2);*/

		Teacher teacher1 = new Teacher();
		teacher1.setMatiereEnseigne("ANGLAIS");
		teacher1.setVacant(true);
		teacher1.setPrenom("tit");
		teacher1.setNom("coulibaly");

		teacher1.setMail("titi@gmail.com");
		//teacher1.setAdress(addressTeacher1);



		Teacher teacher2 = new Teacher();
		teacher2.setMatiereEnseigne("AUHGF-KK");
		teacher2.setVacant(true);
		teacher2.setPrenom("toto");

		teacher2.setNom("kouame");
		teacher2.setMail("toto@gmail.com");
		//teacher2.setAdress(addressTeacher2);

		teacherService.save(teacher1);
		teacherService.save(teacher2);


       //teacher2.setAdress(addressTeacher2);
		User user = new User();
		user.setIdentifiant("KONE");
		user.setMotDePasse("KOKO123");
		user.setDateCreation(Instant.now());

		User user1 = new User();
		user1.setIdentifiant("ALI");
		user1.setMotDePasse("ALOCO123");
		user1.setDateCreation(Instant.now());

		userService.save(user);
		userService.save(user1);






	}


}
