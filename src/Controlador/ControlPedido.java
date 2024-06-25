/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Pedido;
import Vista.VentanaPrincipal;
import java.util.ArrayList;

/**
 *
 * @author Milton Rodriguez
 */
public class ControlPedido {
    VentanaPrincipal vp;
    public static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public ControlPedido() {
    }

    public void setVp(VentanaPrincipal vp) {
        this.vp = vp;
    }

    public void realizarPedido(){
        Pedido p = new Pedido();
        p.setNombre(vp.getTxtnombremedicamento().getText());
        
        if(vp.getTxtnombremedicamento().getText().replace(" ","").equals("")){
            vp.mostrarMsgErrorNombre();
            return;
        }
        
        p.setTipo((String)vp.getCombotipo().getSelectedItem());
        
        try{
            p.setCantidad(Integer.parseInt(vp.getTxtcantidad().getText()));
        }catch(NumberFormatException e){
            vp.mostrarMsgErrorCantidad();
            return;
        }
        
        if(Integer.parseInt(vp.getTxtcantidad().getText())<=0){
            vp.mostrarMsgErrorCantidad();
            return;
        }
        
        if(vp.getRadiocofarma().isSelected()){
            p.setDistribuidor("Cofarma");
        }
        if(vp.getRadioempsephar().isSelected()){
            p.setDistribuidor("Empsephar");
        }
        if(vp.getRadiocemefar().isSelected()){
            p.setDistribuidor("Cemefar");
        }
        
        if(!vp.getRadiocofarma().isSelected()&&!vp.getRadioempsephar().isSelected()&&!vp.getRadiocemefar().isSelected()){
            vp.mostrarMsgErrorDistribuidor();
            return;
        }
        
        
        
        if(vp.getChecknorte().isSelected()){
            p.setSucursal("Sede norte");
        }
        if(vp.getChecksur().isSelected()){
            p.setSucursal("Sede sur");
        }
        
        
        if(!vp.getChecknorte().isSelected()&&!vp.getChecksur().isSelected()){
            vp.mostrarMsgErrorSucursal();
            return;
        }
        
        
        pedidos.add(p);
        
        System.out.println(p.toString());
        
        vp.getModelo1().addRow(new Object[]{p.getNombre(),p.getTipo(),p.getCantidad(),p.getDistribuidor(),p.getSucursal()});
    }
    
    public void borrarFormulario(){
        vp.getTxtnombremedicamento().setText("");
        vp.getTxtcantidad().setText("");
        vp.getB().clearSelection();//obtengo el buttongroup b de ventanaprincipal y le aplico el metodo clearSelection() para des-seleccionarlos todos.
        vp.getB2().clearSelection();
    }
    
    public void setearModelo1enJtable(){
        vp.getTabla().setModel(vp.getModelo1());
        
        vp.getTxtnombremedicamento2().setEnabled(false);
        vp.getCombosucursal().setEnabled(false);
        vp.getBotonbuscar().setEnabled(false);
    }
    
    public void setearModelo2enJtable(){
        vp.getTabla().setModel(vp.getModelo2());
        
        vp.getTxtnombremedicamento2().setEnabled(true);
        vp.getCombosucursal().setEnabled(true);
        vp.getBotonbuscar().setEnabled(true);
    }
    
    public void busquedaPedidos(){
        vp.getModelo2().setRowCount(0);//elimino todas las filas del modelo 2, para agregar las nuevas en base a los parametros de busqueda ingresados por el usuario (nombre de medicamento y sucursal)
        
        for(int i=0;i<pedidos.size();i++){
            if(pedidos.get(i).getNombre().equals(vp.getTxtnombremedicamento2().getText())||pedidos.get(i).getSucursal().equals(vp.getCombosucursal().getSelectedItem())){
                vp.getModelo2().addRow(new Object[]{pedidos.get(i).getNombre(),pedidos.get(i).getTipo(),pedidos.get(i).getCantidad(),pedidos.get(i).getDistribuidor(),pedidos.get(i).getSucursal()});
            }
        }
        
        vp.getTabla().setModel(vp.getModelo2());//seteo el nuevo modelo en la tabla
    }
    
    
}
