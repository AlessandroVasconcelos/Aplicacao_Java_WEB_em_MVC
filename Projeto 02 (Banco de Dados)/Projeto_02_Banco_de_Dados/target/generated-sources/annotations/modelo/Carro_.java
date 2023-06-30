package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Proprietario;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-06-29T21:52:50")
@StaticMetamodel(Carro.class)
public class Carro_ { 

    public static volatile SingularAttribute<Carro, String> marca;
    public static volatile SingularAttribute<Carro, Proprietario> proprietarioId;
    public static volatile SingularAttribute<Carro, Integer> id;
    public static volatile SingularAttribute<Carro, String> modelo;
    public static volatile SingularAttribute<Carro, String> placa;

}