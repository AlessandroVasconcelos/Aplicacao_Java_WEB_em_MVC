package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import modelo.Carro;

@Named("carroBean")
@SessionScoped
public class CarroBean implements Serializable {

    private List<Carro> carros = new ArrayList<Carro>();
    private Carro carro = new Carro();
    private Carro carroA;

    private boolean alterar = false;
    Random random = new Random();
    private final Set<Integer> idsCarrosUtilizados = new HashSet<>();

    public List<Carro> getCarros() {
        return carros;
    }

    public String nomeBotao() {
        if (alterar) {
            return "Salvar";
        } else {
            return "Adicionar";
        }
    }

    public int adicionarIdCarro() {
        int nextId = idsCarrosUtilizados.isEmpty() ? 1 : Collections.max(idsCarrosUtilizados) + 1;
        idsCarrosUtilizados.add(nextId);
        return nextId;
    }

    public void adicionarCarro() {
        if (!alterar) {
            boolean jaExiste = false;
            for (Carro c : carros) {
                if (c.getPlaca().equals(carro.getPlaca())) {
                    jaExiste = true;
                    break;
                }
            }
            if (jaExiste) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro. Esse carro já foi cadastrado. (Placas iguais)", ""));
                return;
            }
        } else {
            for (Carro c : carros) {
                if (c.getPlaca().equals(carro.getPlaca()) && !c.equals(carroA)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro. Esse carro já foi cadastrado. (Placas iguais)", ""));
                    return;
                }
            }
        }
        int id = adicionarIdCarro();
        if (alterar) {
            carros.set(carros.indexOf(carroA), carro);
        } else {
            this.carro.setId(id);
            this.carros.add(this.carro);
        }
        alterar = false;
        this.carro = new Carro();
    }

    public boolean botaoCancelarCar() {
        return (carro.getPlaca() == null);
    }

    public void cancelarCar() {
        alterar = false;
        this.carro = new Carro();
    }

    public void removerCarro(Carro carro) {
        this.carros.remove(carro);
        System.out.println("removeu");
    }

    public void carregarCar(Carro carro) {
        carroA = carro;
        this.carro = carro.clone();
        alterar = true;
    }

    public Carro getCarro() {
        return carro;
    }

    public Carro getCarro(String placa) {
        Carro carroSearch = null;
        for (Carro c : carros) {
            if (c.getPlaca().equals(placa)) {
                carroSearch = c;
            }
        }
        return carroSearch;
    }

    // GETTER E SETTER
    @FacesConverter(forClass = Carro.class)
    public static class ProprietarioBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CarroBean controller = (CarroBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "carroBean");
            return controller.getCarro(value);
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return ((Carro) object).getPlaca();
        }

    }

}
