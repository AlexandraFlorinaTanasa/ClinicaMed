package org.app.clinicamed.web.views.clienti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.clinicamed.oop.p8.web.clinicamed.MainView;
import org.entity.Pacienti;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("pacienti")
@Route(value = "pacienti", layout = MainView.class)

public class NavigableGridClientiView extends VerticalLayout implements HasUrlParameter<Integer>{
	// Definire model date
	private EntityManager em;
	private List<Pacienti> pacienti = new ArrayList<>();
	private Pacienti pacient = null;
	private Binder<Pacienti> binder = new BeanValidationBinder<>(Pacienti.class);
	
	// Definire componente view
	private H1 titluForm = new H1("Lista Pacienti");
	
	// Definire componente suport navigare
	private VerticalLayout gridLayoutToolbar;
	private TextField filterText = new TextField();
	private Button cmdEditPacient = new Button("Editeaza pacient...");
	private Button cmdAdaugaPacient = new Button("Adauga pacient...");
	private Button cmdStergePacient = new Button("Sterge pacient");
	private Grid<Pacienti> grid = new Grid<>(Pacienti.class);
	
	// init Data Model
	private void initDataModel(){
	System.out.println("DEBUG START FORM >>> ");
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClinicaMedJPA");
	em = emf.createEntityManager();
	List<Pacienti> lst = em
	.createQuery("SELECT p FROM Pacienti p ORDER BY p.id", Pacienti.class)
	.getResultList();
	pacienti.addAll(lst);
	if (lst != null && !lst.isEmpty()){
	Collections.sort(this.pacienti, (p1, p2) -> p1.getId().compareTo(p2.getId()));
	this.pacient = pacienti.get(0);
	System.out.println("DEBUG: pacient init >>> " + pacient.getId());
	}
	//
	grid.setItems(this.pacienti);
	binder.setBean(this.pacient);
	grid.asSingleSelect().setValue(this.pacient);
	}
	// init View Model
	private void initViewLayout() {
	// Layout navigare -------------------------------------//
	// Toolbar navigare
	filterText.setPlaceholder("Filter by nume...");
	filterText.setClearButtonVisible(true);
	filterText.setValueChangeMode(ValueChangeMode.LAZY);
	HorizontalLayout gridToolbar = new HorizontalLayout(filterText,
	cmdEditPacient, cmdAdaugaPacient, cmdStergePacient);
	// Grid navigare
	grid.setColumns("id", "nume");
	grid.addComponentColumn(item -> createGridActionsButtons(item)).setHeader("Actiuni");
	// Init Layout navigare
	gridLayoutToolbar = new VerticalLayout(gridToolbar, grid);
	// ---------------------------
	this.add(titluForm, gridLayoutToolbar);
	//
	}
	private Component createGridActionsButtons(Pacienti item) {
		//
		Button cmdEditItem = new Button("Edit");
		cmdEditItem.addClickListener(e -> {
		grid.asSingleSelect().setValue(item);
		editPacient();
		});
		Button cmdDeleteItem = new Button("Sterge");
		cmdDeleteItem.addClickListener(e -> {
		System.out.println("Sterge item: " + item);
		grid.asSingleSelect().setValue(item);
		stergePacient();
		refreshForm();
		} );
		//
		return new HorizontalLayout(cmdEditItem, cmdDeleteItem);
		}
	
	// init Controller components
	private void initControllerActions() {
	// Navigation Actions
	filterText.addValueChangeListener(e -> updateList());
	cmdEditPacient.addClickListener(e -> {
	editPacient();
	});
	cmdAdaugaPacient.addClickListener(e -> {
	adaugaPacient();
	});
	cmdStergePacient.addClickListener(e -> {
	stergePacient();
	refreshForm();
	});
	}
	// CRUD actions
	// Adaugare: delegare catre Formular detalii pacient
	private void adaugaPacient() {
	this.getUI().ifPresent(ui -> ui.navigate(FormClientView.class, 999));
	}
	// Editare: delegare catre Formular detalii pacient
	private void editPacient() {
	this.pacient = this.grid.asSingleSelect().getValue();
	System.out.println("Selected pacient:: " + pacient);
	if (this.pacient != null) {
	this.getUI().ifPresent(ui -> ui.navigate(
	FormClientView.class, this.pacient.getId())
	);
	}
	}
	// CRUD actions
	// Stergere: tranzactie locala cu EntityManager
	private void stergePacient() {
	this.pacient = this.grid.asSingleSelect().getValue();
	System.out.println("To remove: " + this.pacient);
	this.pacienti.remove(this.pacient);
	if (this.em.contains(this.pacient)) {
	this.em.getTransaction().begin();
	this.em.remove(this.pacient);
	this.em.getTransaction().commit();
	}
	if (!this.pacienti.isEmpty())
	this.pacient = this.pacienti.get(0);
	else
	this.pacient = null;
	}
	// Start Form
	public NavigableGridClientiView() {
	//
	initDataModel();
	//
	initViewLayout();
	//
	initControllerActions();
	}
	// Populare grid cu set de date din model - filtrare
	private void updateList() {
	try {
	List<Pacienti> lstPacientiFiltered = this.pacienti;
	if (filterText.getValue() != null) {
	lstPacientiFiltered = this.pacienti.stream()
	.filter(p -> p.getNume().contains(filterText.getValue()))
	.toList();
	grid.setItems(lstPacientiFiltered);
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	// Resincronizare componente-view cu modelul de date
	private void refreshForm() {
	System.out.println("Pacient curent: " + this.pacient);
	if (this.pacient != null) {
	grid.setItems(this.pacienti);
	binder.setBean(this.pacient);
	grid.select(this.pacient);
	}
	}
	
	// … … //
	// Navigation Management:
	// URL-ul http://localhost:8080/clienti/3 asigură selecția clientului cu ID 3
	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter Integer id) {
	if (id != null) {
	this.pacient = em.find(Pacienti.class, id);
	System.out.println("Back pacient: " + pacient);
	if (this.pacient == null) {
	// DELETED Item
	if (!this.pacienti.isEmpty())
	this.pacient = this.pacienti.get(0);
	}
	// else: EDITED or NEW Item
	}
	this.refreshForm();
	}
	// … … //
	}
 


