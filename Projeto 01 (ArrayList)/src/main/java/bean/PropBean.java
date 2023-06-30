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

import modelo.Proprietario;

@Named("propBean")
@SessionScoped
public class PropBean implements Serializable {

    private List<Proprietario> proprietarios = new ArrayList<Proprietario>();
    private Proprietario proprietario = new Proprietario();
    private Proprietario proprietarioA;

    private boolean alterar = false;
    Random random = new Random();
    private final Set<Integer> idsProprietariosUtilizados = new HashSet<>();

    public List<Proprietario> getProprietarios() {
        return proprietarios;
    }

    public String nomeBotao() {
        if (alterar) {
            return "Salvar";
        } else {
            return "Adicionar";
        }
    }

    public int adicionarIdProprietario() {
        int nextId = idsProprietariosUtilizados.isEmpty() ? 1 : Collections.max(idsProprietariosUtilizados) + 1;
        idsProprietariosUtilizados.add(nextId);
        return nextId;
    }

    public void adicionarProprietario() {
        if (!alterar) {
            boolean jaExiste = false;
            for (Proprietario p : proprietarios) {
                if (p.getCpf().equals(proprietario.getCpf())) {
                    jaExiste = true;
                    break;
                }
            }
            if (jaExiste) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro. Esse proprietário já foi cadastrado. (CPFs iguais)", ""));
                return;
            }
        } else {
            for (Proprietario p : proprietarios) {
                if (p.getCpf().equals(proprietario.getCpf()) && !p.equals(proprietarioA)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro. Esse proprietário já foi cadastrado. (CPFs iguais)", ""));
                    return;
                }
            }
        }

        int id = adicionarIdProprietario();
        if (alterar) {
            proprietarios.set(proprietarios.indexOf(proprietarioA), proprietario);
        } else {
            this.proprietario.setId(id);
            this.proprietarios.add(this.proprietario);
        }
        alterar = false;
        this.proprietario = new Proprietario();
    }

    public boolean botaoCancelarProp() {
        return (proprietario.getCpf() == null);
    }

    public void cancelarProp() {
        alterar = false;
        this.proprietario = new Proprietario();
    }

    public void removerProprietario(Proprietario proprietario) {
        this.proprietarios.remove(proprietario);
        System.out.println("removeu");
    }

    public void carregarProp(Proprietario proprietario) {
        proprietarioA = proprietario;
        this.proprietario = proprietario.clone();
        alterar = true;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public Proprietario getProprietario(String cpf) {
        Proprietario proprietarioSearch = null;
        for (Proprietario p : proprietarios) {
            if (p.getCpf().equals(cpf)) {
                proprietarioSearch = p;
            }
        }
        return proprietarioSearch;
    }

    public String getProprietarioNome(int proprietarioid) {
        for (Proprietario p : proprietarios) {
            if (p.getId() == proprietarioid) {
                return p.getNome();
            }
        }
        return "";
    }

    // GETTER E SETTER
    @FacesConverter(forClass = Proprietario.class)
    public static class PropBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PropBean controller = (PropBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "propBean");
            return controller.getProprietario(value);
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return ((Proprietario) object).getCpf();
        }

    }

}
