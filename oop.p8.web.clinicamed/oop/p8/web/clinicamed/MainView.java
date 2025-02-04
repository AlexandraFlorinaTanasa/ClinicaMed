package org.app.clinicamed.oop.p8.web.clinicamed;


import org.app.clinicamed.web.views.clienti.FormClientView;
import org.app.clinicamed.web.views.clienti.NavigableGridClientiView;
import org.app.clinicamed.web.views.medici.FormMedicView;
import org.app.clinicamed.web.views.medici.NavigableGridMediciView;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

/**
 * The main view contains a button and a click listener.
 */
@Route
public class MainView extends VerticalLayout implements RouterLayout {

	public MainView() {
		setMenuBar();
		}
		private void setMenuBar() {
		MenuBar mainMenu = new MenuBar();
		MenuItem homeMenu = mainMenu.addItem("Home");
		homeMenu.addClickListener(event -> UI.getCurrent().navigate(MainView.class));
		//
		MenuItem gridFormsPacientiMenu = mainMenu.addItem("Pacienti");
		SubMenu gridFormsPacientiMenuBar = gridFormsPacientiMenu.getSubMenu();
		gridFormsPacientiMenuBar.addItem("Lista Pacienti...",
		event -> UI.getCurrent().navigate(NavigableGridClientiView.class));
		gridFormsPacientiMenuBar.addItem("Form Editare Pacient...",
		event -> UI.getCurrent().navigate(FormClientView.class));
		//
		MenuItem gridFormsMedicMenu = mainMenu.addItem("Medic ");
		SubMenu gridFormsMedicMenuBar = gridFormsMedicMenu.getSubMenu();
		gridFormsMedicMenuBar.addItem("Lista Medici...",
		event -> UI.getCurrent().navigate(NavigableGridMediciView.class));
		gridFormsMedicMenuBar.addItem("Form Editare Retete...",
		event -> UI.getCurrent().navigate(FormMedicView.class)); 
		add(new HorizontalLayout(mainMenu));
		}
		
		}

