package com.project.neo;

import java.io.File;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

@ManagedBean(eager = false, name = "serviceManagerBean")
@ApplicationScoped
public class ServiceManagerBean implements Serializable {

    private static final String DB_PATH = "C:/neo4j/db/sport_db";

    private File db = new File(DB_PATH);

    private GraphDatabaseFactory graphDbFactory = null;
    private GraphDatabaseService databaseService = null;

    public ServiceManagerBean() {
        graphDbFactory = new GraphDatabaseFactory();
        databaseService = graphDbFactory.newEmbeddedDatabase(db);
    }

    @PostConstruct
    public void init() {

    }

    public GraphDatabaseService getDatabaseService() {
        return databaseService;
    }

}
