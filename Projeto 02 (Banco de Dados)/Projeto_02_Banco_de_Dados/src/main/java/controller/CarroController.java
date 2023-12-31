package controller;

import modelo.Carro;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import facade.CarroFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Proprietario;

@Named("carroController")
@SessionScoped
public class CarroController implements Serializable {

    @EJB
    private facade.CarroFacade ejbFacade;
    private List<Carro> items = null;
    private Carro selected;
    private Proprietario proprietario = new Proprietario();

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public CarroController() {
    }

    public Carro getSelected() {
        return selected;
    }

    public void setSelected(Carro selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CarroFacade getFacade() {
        return ejbFacade;
    }

    public Carro prepareCreate() {
        selected = new Carro();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CarroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CarroUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CarroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Carro> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Carro getCarro(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Carro> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Carro> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Carro.class)
    public static class CarroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CarroController controller = (CarroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "carroController");
            return controller.getCarro(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Carro) {
                Carro o = (Carro) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Carro.class.getName()});
                return null;
            }
        }

    }

    public String cancelar() {
        System.out.println("cancelar");
        this.selected = null;
        proprietario = new Proprietario();
        return "carro";
    }

    public Carro getCarro() {
        return selected;
    }

    public List<Carro> getCarros() {
        items = getFacade().findAll();
        return items;
    }

    public void gravar() {
        System.out.println("Gravando Carros " + this.selected.getPlaca());

        selected.setProprietarioId(proprietario);
        if (this.selected.getId() == null) {
            create();
        } else {
            update();
        }

        this.selected = null;
        proprietario = new Proprietario();
    }

    public boolean novoHabilitado() {
        return (selected == null);
    }

    public void carregar(Carro carro) {
        System.out.println("Carregando Carro");
        this.selected = carro;
        proprietario = selected.getProprietarioId();
    }

    public void remover(Carro carro) {
        System.out.println("Removendo Carro");
        this.selected = carro;
        destroy();
    }

    public Carro buscarCarro(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public boolean temId() {
        return (selected.getId() != null);
    }

    public CarroFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(CarroFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

}
