package au.edu.anu.ymuit.util;

import java.text.DecimalFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class Decimals {
	public static DecimalFormat getDecimalFormat(int nd) {
		String res = "#0";
		if (nd > 0)
			res = res + ".";
		for (int i = 0; i < nd; i++)
			res = res + "0";
		return new DecimalFormat(res);
	}

	public static void installDecimalListener(TextField tf) {
        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    tf.setText(oldValue);
                }
            }
        });
	}

}
