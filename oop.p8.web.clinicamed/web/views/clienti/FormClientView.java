package org.app.clinicamed.web.views.clienti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

 import org.app.clinicamed.oop.p8.web.clinicamed.MainView;
import org.entity.Pacienti;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("pacient")
@Route(value = "pacient", layout = MainView.class)

	public class FormClientView extends VerticalLayout implements HasUrlParameter<Integer>{

	
	// Definire model date
	private EntityManager em;
	private Pacienti pacient = null;
	private Binder<Pacienti> binder = new BeanValidationBinder<>(Pacienti.class);
	// Definire componente view
	// Definire Form
	private VerticalLayout formLayoutToolbar;
	private H1 titluForm = new H1("Form Pacient");
	private IntegerField id = new IntegerField("ID pacient:");
	private TextField nume = new TextField("Nume pacient: ");
	// Definire componente actiuni Form-Controller
	private Button cmdAdaugare = new Button("Adauga");
	private Button cmdSterge = new Button("Sterge");
	private Button cmdAbandon = new Button("Abandon");
	private Button cmdSalveaza = new Button("Salveaza");
		// … … //
		// Navigation Management:
		// URL-ul http://localhost:8080/clienti/3 asigură afișare detaliilor clientului cu ID 3
		@Override
		public void setParameter(BeforeEvent event, @OptionalParameter Integer id) {
		System.out.println("Pacient ID: " + id);
		if (id != null) {
		// EDIT Item
		this.pacient = em.find(Pacienti.class, id);
		System.out.println("Selected pacient to edit:: " + pacient);
		if (this.pacient == null) {
		System.out.println("ADD pacient:: " + pacient);
		// NEW Item
		this.adaugaPacient();
		this.pacient.setId(id);
		this.pacient.setNume("Pacient NOU " + id);
		}
		}
		this.refreshForm();
		}
		
		// init Data Model
		private void initDataModel(){
		System.out.println("DEBUG START FORM >>> ");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaMedJPA");
		this.em = emf.createEntityManager();
		this.pacient = em
		.createQuery("SELECT p FROM Pacienti p ORDER BY p.id", Pacienti.class)
		.getResultStream().findFirst().get();
		//
		binder.forField(id).bind("id");
		binder.forField(nume).bind("nume");
		//
		refreshForm();
		}
		// init View Model
		private void initViewLayout() {
		// Form-Master-Details -----------------------------------//
		// Form-Master
		FormLayout formLayout = new FormLayout();
		formLayout.add(id, nume);
		formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
		formLayout.setMaxWidth("400px");
		// Toolbar-Actions-Master
		HorizontalLayout actionToolbar =
		new HorizontalLayout(cmdAdaugare, cmdSterge, cmdAbandon, cmdSalveaza);
		actionToolbar.setPadding(false);
		//
		this.formLayoutToolbar = new VerticalLayout(formLayout, actionToolbar);
		// ---------------------------
		this.add(titluForm, formLayoutToolbar);
		//
		}
		// init Controller components
		private void initControllerActions() {
		// Transactional Master Actions
		cmdAdaugare.addClickListener(e -> {
		adaugaPacient();
		refreshForm();
		});
		cmdSterge.addClickListener(e -> {
		stergePacient();
		// Navigate back to NavigableGridClienteForm
		this.getUI().ifPresent(ui -> ui.navigate(
		NavigableGridClientiView.class)
		);
		});
		cmdAbandon.addClickListener(e -> {
		// Navigate back to NavigableGridClienteForm
		this.getUI().ifPresent(ui -> ui.navigate(
		NavigableGridClientiView.class, this.pacient.getId())
		);
		});
		cmdSalveaza.addClickListener(e -> {
		salveazaPacient();
		// refreshForm();
		// Navigate back to NavigableGridClienteForm
		this.getUI().ifPresent(ui -> ui.navigate(
		NavigableGridClientiView.class, this.pacient.getId())
		);
		});
		}
		private void refreshForm() {
			System.out.println("Pacient curent: " + this.pacient);
			if (this.pacient != null) {
			binder.setBean(this.pacient);
			}
			}
		// CRUD actions
		private void salveazaPacient() {
		try {
		this.em.getTransaction().begin();
		this.pacient = this.em.merge(this.pacient);
		this.em.getTransaction().commit();
		System.out.println("Pacient Salvat");
		} catch (Exception ex) {
		if (this.em.getTransaction().isActive())
		this.em.getTransaction().rollback();
		System.out.println("*** EntityManager Validation ex: " + ex.getMessage());
		throw new RuntimeException(ex.getMessage());
		}
		}
		// CRUD actions
		private void adaugaPacient() {
		this.pacient = new Pacienti();
		this.pacient.setId(999); // ID arbitrar, inexistent în baza de date
		this.pacient.setNume("Pacient Nou");
		}
		// CRUD actions
		private void stergePacient() {
		System.out.println("To remove: " + this.pacient);
		if (this.em.contains(this.pacient)) {
		this.em.getTransaction().begin();
		this.em.remove(this.pacient);
		this.em.getTransaction().commit();
		}
		}
		// Start Form
		public FormClientView() {
		//
		initDataModel();
		//
		initViewLayout();
		//
		initControllerActions();
		}
	}
	

