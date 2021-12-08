/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vulkan.declaracion;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
/**
 *
 * @author gabri
 */
public class facturaDataSource implements JRDataSource{

    /**
     * @param args the command line arguments
     */
    private final Object[][] detallesFactura;
    private int index;

    public facturaDataSource(Object[][] detallesFactura)
    {
        this.detallesFactura = detallesFactura;
        index = -1;
    }


    @Override
    public boolean next() throws JRException {
        index++;
        return (index < detallesFactura.length);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        String nombreCampo = jrf.getName();

        switch(nombreCampo)
        {
            case "Menu":
                valor = detallesFactura[index][0];
                break;
            case "Precio":
                valor = detallesFactura[index][1];
                break;
            case "Cantidad":
                valor = detallesFactura[index][2];
                break;            
        }
        return valor;
    }

    public static JRDataSource getDataSource(Object[][] detallesFactura)
    {
        return new facturaDataSource(detallesFactura);
    }
}
