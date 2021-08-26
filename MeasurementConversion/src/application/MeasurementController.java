package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MeasurementController implements Initializable {
	
    @FXML
    private TextField unitIIText;

    @FXML
    private TextField unitIText;

    @FXML
    private ComboBox<String> unitIICB;

    @FXML
    private ComboBox<String> unitICB;
    
    @FXML
    private ComboBox<String> unitTypeCB;

    private ObservableList<String> unit = (ObservableList<String>) FXCollections.observableArrayList("Distance", "Volume", "Poids", "Température");
    private ObservableList<String> distance = (ObservableList<String>) FXCollections.observableArrayList("Millimètres", "Centimètres", "Mètres", "Kilomètres", "Pouces", "Pieds", "Miles");
    private ObservableList<String> volume = (ObservableList<String>) FXCollections.observableArrayList("Millilitres", "Litres", "Mètres Cubes", "Pouces Cubes", "Pieds Cubes", "Gallons Américains", "Gallons Impériaux");
    private ObservableList<String> weight = (ObservableList<String>) FXCollections.observableArrayList("Milligrammes", "Grammes", "Kilogrammes", "Livres", "Onces", "Tonnes Américaines", "Tonnes Impériales");
    private ObservableList<String> temperature = (ObservableList<String>) FXCollections.observableArrayList("Celsius", "Fahrenheit", "Kelvin");
    
    public static Double unitI;
    public static Double unitII;
    public static Double conversion;
    
    public static Double mm_m = 0.001;
    public static Double cm_m = 0.01;
    public static Double km_m = 1000.0;
    public static Double in_m = 0.0254;
    public static Double ft_m = 0.3048;
    public static Double mi_m = 1609.34;
    
    public static Double m_mm = 1000.0;
    public static Double m_cm = 100.0;
    public static Double m_km = 0.001;
    public static Double m_in = 39.3701;
    public static Double m_ft = 3.280841666667;
    public static Double m_mi = 0.00062137152777784086452;
    
    public static Double ml_l = 0.001;
    public static Double m3_l = 1000.0;
    public static Double in3_l = 0.0163871;
    public static Double ft3_l = 28.3168;
    public static Double usg_l = 3.78541;
    public static Double impg_l = 4.54609;
    
    public static Double l_ml = 1000.0;
    public static Double l_m3 = 0.001;
    public static Double l_in3 = 61.0237;
    public static Double l_ft3 = 0.0353147;
    public static Double l_usg = 0.264172;
    public static Double l_impg = 0.219969204701183;
    
    public static Double mg_p = 2.2046e-6;
    public static Double g_p = 0.00220462;
    public static Double kg_p = 2.20462;
    public static Double oz_p = 0.06249992566875;
    public static Double ust_p = 2000.0;
    public static Double impt_p = 2240.0;
    
    public static Double p_mg = 453592.0;
    public static Double p_g = 453.592;
    public static Double p_kg = 0.453592;
    public static Double p_oz = 16.0;
    public static Double p_ust = 0.0005;
    public static Double p_impt = 0.000446429;
    
    public static Double f_c = 0.55555555555;
    public static Double k_c = -273.15;
    
    public static Double c_f = 1.8;
    public static Double c_k = 273.15;
    
    public void initialize(URL location, ResourceBundle resources) {
    	
		unitTypeCB.setItems(unit);
    }
    
    @FXML
    void switchUnitType(ActionEvent event) {
    	
    	if (unitTypeCB.getValue() == "Distance") {
    		
    		unitICB.setItems(distance);
    		unitIICB.setItems(distance);
    		
    	} else if (unitTypeCB.getValue() == "Volume") {
    		
    		unitICB.setItems(volume);
    		unitIICB.setItems(volume);
    		
    	} else if (unitTypeCB.getValue() == "Poids") {
    		
    		unitICB.setItems(weight);
    		unitIICB.setItems(weight);
    		
    	} else if (unitTypeCB.getValue() == "Température") {
    		
    		unitICB.setItems(temperature);
    		unitIICB.setItems(temperature);
    		
    	}
    	
    	unitIText.setText("");
    	unitIIText.setText("");
    	
    }
    
    @FXML
    void convertUnitI() {
    	
    	//Distance

    	if (unitICB.getValue() == "Millimètres") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*mm_m;
    		
    	} else if (unitICB.getValue() == "Centimètres") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*cm_m;
    		
    	} else if (unitICB.getValue() == "Mètres") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI;
    		
    	} else if (unitICB.getValue() == "Kilomètres") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*km_m;
    		
    	} else if (unitICB.getValue() == "Pouces") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*in_m;
    		
    	} else if (unitICB.getValue() == "Pieds") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*ft_m;
    		
    	} else if (unitICB.getValue() == "Miles") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*mi_m;
    		
    	}
    	
    	
    	if (unitIICB.getValue() == "Millimètres") {
    		
    		unitII = conversion*m_mm;
    		
    	} else if (unitIICB.getValue() == "Centimètres") {
    		
    		unitII = conversion*m_cm;
    		
    	} else if (unitIICB.getValue() == "Mètres") {
    		
    		unitII = conversion;
    		
    	} else if (unitIICB.getValue() == "Kilomètres") {
    		
    		unitII = conversion*m_km;
    		
    	} else if (unitIICB.getValue() == "Pouces") {
    		
    		unitII = conversion*m_in;
    		
    	} else if (unitIICB.getValue() == "Pieds") {
    		
    		unitII = conversion*m_ft;
    		
    	} else if (unitIICB.getValue() == "Miles") {
    		
    		unitII = conversion*m_mi;
    		
    	}
    	
    	
    	//Volume
    	
    	if (unitICB.getValue() == "Millilitres") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*ml_l;
    		
    	} else if (unitICB.getValue() == "Litres") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI;
    		
    	} else if (unitICB.getValue() == "Mètres Cubes") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*m3_l;
    		
    	} else if (unitICB.getValue() == "Pouces Cubes") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*in3_l;
    		
    	} else if (unitICB.getValue() == "Pieds Cubes") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*ft3_l;
    		
    	} else if (unitICB.getValue() == "Gallons Américains") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*usg_l;
    		
    	} else if (unitICB.getValue() == "Gallons Impériaux") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*impg_l;
    		
    	}
    	
    	
    	if (unitIICB.getValue() == "Millilitres") {
    		
    		unitII = conversion*l_ml;
    		
    	} else if (unitIICB.getValue() == "Litres") {
    		
    		unitII = conversion;
    		
    	} else if (unitIICB.getValue() == "Mètres Cubes") {
    		
    		unitII = conversion*l_m3;
    		
    	} else if (unitIICB.getValue() == "Pouces Cubes") {
    		
    		unitII = conversion*l_in3;
    		
    	} else if (unitIICB.getValue() == "Pieds Cubes") {
    		
    		unitII = conversion*l_ft3;
    		
    	} else if (unitIICB.getValue() == "Gallons Américains") {
    		
    		unitII = conversion*l_usg;
    		
    	} else if (unitIICB.getValue() == "Gallons Impériaux") {
    		
    		unitII = conversion*l_impg;
    		
    	}
    	
    	
    	//Weight
    	
    	if (unitICB.getValue() == "Milligrammes") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*mg_p;
    		
    	} else if (unitICB.getValue() == "Grammes") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*g_p;
    		
    	} else if (unitICB.getValue() == "Kilogrammes") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*kg_p;
    		
    	} else if (unitICB.getValue() == "Livres") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI;
    		
    	} else if (unitICB.getValue() == "Onces") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*oz_p;
    		
    	} else if (unitICB.getValue() == "Tonnes Américaines") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*ust_p;
    		
    	} else if (unitICB.getValue() == "Tonnes Impériales") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI*impt_p;
    		
    	}
    	
    	
    	if (unitIICB.getValue() == "Milligrammes") {
    		
    		unitII = conversion*l_ml;
    		
    	} else if (unitIICB.getValue() == "Grammes") {
    		
    		unitII = conversion;
    		
    	} else if (unitIICB.getValue() == "Kilogrammes") {
    		
    		unitII = conversion*l_m3;
    		
    	} else if (unitIICB.getValue() == "Livres") {
    		
    		unitII = conversion*l_in3;
    		
    	} else if (unitIICB.getValue() == "Onces") {
    		
    		unitII = conversion*l_ft3;
    		
    	} else if (unitIICB.getValue() == "Tonnes Américaines") {
    		
    		unitII = conversion*l_usg;
    		
    	} else if (unitIICB.getValue() == "Tonnes Impériales") {
    		
    		unitII = conversion*l_impg;
    		
    	}
    	
    	
    	//Temperature
    	
    	if (unitICB.getValue() == "Celsius") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI;
    		
    	} else if (unitICB.getValue() == "Fahrenheit") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = (unitI - 32)*f_c;
    		
    	} else if (unitICB.getValue() == "Kelvin") {
    		
    		unitI = Double.parseDouble(unitIText.getText());
    		conversion = unitI + k_c;
    		
    	}
    	
    	
    	if (unitIICB.getValue() == "Celsius") {
    		
    		unitII = conversion;
    		
    	} else if (unitIICB.getValue() == "Fahrenheit") {
    		
    		unitII = (conversion*c_f) + 32;
    		
    	} else if (unitIICB.getValue() == "Kelvin") {
    		
    		unitII = conversion + c_k;
    		
    	}
    	
    	//Same
    	
    	if (unitICB.getValue() == unitIICB.getValue()) {
    		
    		unitII = unitI;
    		
    	}
    	
    	unitIIText.setText(Double.toString(unitII));
    	
    }
    
    @FXML
    void convertUnitII() {
    	
    	//Distance
    	
    	if (unitIICB.getValue() == "Millimètres") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*mm_m;
    		
    	} else if (unitIICB.getValue() == "Centimètres") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*cm_m;
    		
    	} else if (unitIICB.getValue() == "Mètres") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII;
    		
    	} else if (unitIICB.getValue() == "Kilomètres") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*km_m;
    		
    	} else if (unitIICB.getValue() == "Pouces") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*in_m;
    		
    	} else if (unitIICB.getValue() == "Pieds") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*ft_m;
    		
    	} else if (unitIICB.getValue() == "Miles") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*mi_m;
    		
    	}
    	
    	
    	if (unitICB.getValue() == "Millimètres") {
    		
    		unitI = conversion*m_mm;
    		
    	} else if (unitICB.getValue() == "Centimètres") {
    		
    		unitI = conversion*m_cm;
    		
    	} else if (unitICB.getValue() == "Mètres") {
    		
    		unitI = conversion;
    		
    	} else if (unitICB.getValue() == "Kilomètres") {
    		
    		unitI = conversion*m_km;
    		
    	} else if (unitICB.getValue() == "Pouces") {
    		
    		unitI = conversion*m_in;
    		
    	} else if (unitICB.getValue() == "Pieds") {
    		
    		unitI = conversion*m_ft;
    		
    	} else if (unitICB.getValue() == "Miles") {
    		
    		unitI = conversion*m_mi;
    		
    	}
    	
    	
    	//Volume
    	
    	if (unitIICB.getValue() == "Millilitres") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*ml_l;
    		
    	} else if (unitIICB.getValue() == "Litres") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII;
    		
    	} else if (unitIICB.getValue() == "Mètres Cubes") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*m3_l;
    		
    	} else if (unitIICB.getValue() == "Pouces Cubes") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*in3_l;
    		
    	} else if (unitIICB.getValue() == "Pieds Cubes") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*ft3_l;
    		
    	} else if (unitIICB.getValue() == "Gallons Américains") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*usg_l;
    		
    	} else if (unitIICB.getValue() == "Gallons Impériaux") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*impg_l;
    		
    	}
    	
    	
    	if (unitICB.getValue() == "Millilitres") {
    		
    		unitI = conversion*l_ml;
    		
    	} else if (unitICB.getValue() == "Litres") {
    		
    		unitI = conversion;
    		
    	} else if (unitICB.getValue() == "Mètres Cubes") {
    		
    		unitI = conversion*l_m3;
    		
    	} else if (unitICB.getValue() == "Pouces Cubes") {
    		
    		unitI = conversion*l_in3;
    		
    	} else if (unitICB.getValue() == "Pieds Cubes") {
    		
    		unitI = conversion*l_ft3;
    		
    	} else if (unitICB.getValue() == "Gallons Américains") {
    		
    		unitI = conversion*l_usg;
    		
    	} else if (unitICB.getValue() == "Gallons Impériaux") {
    		
    		unitI = conversion*l_impg;
    		
    	}
    	
    	
    	//Weight
    	
    	if (unitIICB.getValue() == "Milligrammes") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*mg_p;
    		
    	} else if (unitIICB.getValue() == "Grammes") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*g_p;
    		
    	} else if (unitIICB.getValue() == "Kilogrammes") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*kg_p;
    		
    	} else if (unitIICB.getValue() == "Livres") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitI;
    		
    	} else if (unitIICB.getValue() == "Onces") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*oz_p;
    		
    	} else if (unitIICB.getValue() == "Tonnes Américaines") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*ust_p;
    		
    	} else if (unitIICB.getValue() == "Tonnes Impériales") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII*impt_p;
    		
    	}
    	
    	
    	if (unitICB.getValue() == "Milligrammes") {
    		
    		unitI = conversion*l_ml;
    		
    	} else if (unitICB.getValue() == "Grammes") {
    		
    		unitI = conversion;
    		
    	} else if (unitICB.getValue() == "Kilogrammes") {
    		
    		unitI = conversion*l_m3;
    		
    	} else if (unitICB.getValue() == "Livres") {
    		
    		unitI = conversion*l_in3;
    		
    	} else if (unitICB.getValue() == "Onces") {
    		
    		unitI = conversion*l_ft3;
    		
    	} else if (unitICB.getValue() == "Tonnes Américaines") {
    		
    		unitI = conversion*l_usg;
    		
    	} else if (unitICB.getValue() == "Tonnes Impériales") {
    		
    		unitI = conversion*l_impg;
    		
    	}
    	
    	
    	//Temperature
    	
    	if (unitIICB.getValue() == "Celsius") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII;
    		
    	} else if (unitIICB.getValue() == "Fahrenheit") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = (unitII - 32)*f_c;
    		
    	} else if (unitIICB.getValue() == "Kelvin") {
    		
    		unitII = Double.parseDouble(unitIIText.getText());
    		conversion = unitII + k_c;
    		
    	}
    	
    	
    	if (unitICB.getValue() == "Celsius") {
    		
    		unitI = conversion;
    		
    	} else if (unitICB.getValue() == "Fahrenheit") {
    		
    		unitI = (conversion*c_f) + 32;
    		
    	} else if (unitICB.getValue() == "Kelvin") {
    		
    		unitI = conversion + c_k;
    		
    	}
    	
    	
    	//Same
    	
    	if (unitIICB.getValue() == unitICB.getValue()) {
    		
    		unitI = unitII;
    		
    	}
    	
    	unitIText.setText(Double.toString(unitI));
    	
    }
    
    @FXML
    void resetToZero(ActionEvent event) {
    	
    	unitIText.setText("");
    	unitIIText.setText("");
    	
    }
    
    @FXML
    void resetAll(ActionEvent event) {
    	
    	unitIText.setText("");
    	unitIIText.setText("");
    	
    	unitICB.setItems(null);
		unitIICB.setItems(null);
		unitTypeCB.setItems(unit);
		unitTypeCB.setValue(null);
    	
    }
    
    @FXML
    void close(ActionEvent event) {
    	
    	System.exit(0);
    	
    }

}
