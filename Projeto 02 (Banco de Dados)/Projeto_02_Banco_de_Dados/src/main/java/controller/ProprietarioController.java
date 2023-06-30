package controller;

import modelo.Proprietario;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import facade.ProprietarioFacade;
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

@Named("proprietarioController")
@SessionScoped
public class ProprietarioController implements Serializable {

    @EJB
    private facade.ProprietarioFacade ejbFacade;
    private List<Proprietario> items = null;
    private Proprietario selected;

    public ProprietarioController() {
    }

    public Proprietario getSelected() {
        return selected;
    }

    public void setSelected(Proprietario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProprietarioFacade getFacade() {
        return ejbFacade;
    }

    public Proprietario prepareCreate() {
        selected = new Proprietario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProprietarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProprietarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProprietarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Proprietario> getItems() {
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

    public Proprietario getProprietario(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Proprietario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Proprietario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Proprietario.class)
    public static class ProprietarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProprietarioController controller = (ProprietarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proprietarioController");
            return controller.getProprietario(getKey(value));
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
            if (object instanceof Proprietario) {
                Proprietario o = (Proprietario) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Proprietario.class.getName()});
                return null;
            }
        }

    }

    public String cancelar() {
        System.out.println("cancelar");
        this.selected = null;
        return "proprietario";
    }

    public Proprietario getProprietario() {
        return selected;
    }

    public List<Proprietario> getProprietarios() {
        items = getFacade().findAll();
        return items;
    }
    
    public void gravar() {
        System.out.println("Gravando Proprietario " + this.selected.getNome());

        if (this.selected.getId() == null) {
            create();
        } else {
            update();
        }

        this.selected = null;

    }

    public boolean novoHabilitado() {
        return (selected == null);
    }

    public void carregar(Proprietario proprietario) {
        System.out.println("Carregando Proprietario");
        this.selected = proprietario;
    }

    public void remover(Proprietario proprietario) {
        System.out.println("Removendo Proprietario");
        this.selected = proprietario;
        destroy();
    }

    public Proprietario buscarProprietario(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public boolean temId() {
        return (selected.getId() != null);
    }

    public ProprietarioFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ProprietarioFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

}