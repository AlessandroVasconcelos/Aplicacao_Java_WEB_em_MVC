/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Proprietario;

/**
 *
 * @author mamat
 */
@Stateless
public class ProprietarioFacade extends AbstractFacade<Proprietario> {

    @PersistenceContext(unitName = "com.mycompany_veiculos_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProprietarioFacade() {
        super(Proprietario.class);
    }
    
}
