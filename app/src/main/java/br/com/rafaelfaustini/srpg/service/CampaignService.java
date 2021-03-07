package br.com.rafaelfaustini.srpg.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.rafaelfaustini.srpg.dao.CampaignDAO;
import br.com.rafaelfaustini.srpg.entity.Campaign;
import br.com.rafaelfaustini.srpg.util.LoggingUtil;
import br.com.rafaelfaustini.srpg.util.SqliteConnection;

public class CampaignService {
    private Context context;

    public CampaignService(Context context) {
        this.context = context;
    }

    public Campaign get(Integer id){
        SQLiteDatabase connection = null;
        Campaign resultado = null;
        try {
            SqliteConnection sqlite = new SqliteConnection(context);
            connection = sqlite.getWritableDatabase();
            CampaignDAO dao = new CampaignDAO(connection);
            resultado = dao.get(id);
        } catch(Exception e) {
            LoggingUtil.error("GetCampaign", e, context);
        } finally {
            connection.close();
            connection = null;
            return resultado;
        }
    }

    public List<Campaign> getAll(){
        SQLiteDatabase connection = null;
        List<Campaign> resultado = null;
        try {
            SqliteConnection sqlite = new SqliteConnection(context);
            connection = sqlite.getWritableDatabase();
            CampaignDAO dao = new CampaignDAO(connection);
            resultado = dao.getAll();
        } catch(Exception e) {
            LoggingUtil.error("GetAllCampaign", e, context);
        } finally {
            connection.close();
            connection = null;
            return resultado;
        }
    }
    public void insert(Campaign c){
        SQLiteDatabase connection = null;
        try {
            SqliteConnection sqlite = new SqliteConnection(context);
            connection = sqlite.getWritableDatabase();
            CampaignDAO dao = new CampaignDAO(connection);
            dao.insert(c);
        } catch(Exception e) {
            LoggingUtil.error("InsertCampaign", e, context);
        } finally {
            connection.close();
            connection = null;
        }
    }

    public void update(Campaign c){
        SQLiteDatabase connection = null;
        try {
            SqliteConnection sqlite = new SqliteConnection(context);
            connection = sqlite.getWritableDatabase();
            CampaignDAO dao = new CampaignDAO(connection);
            dao.update(c);
        } catch(Exception e) {
            LoggingUtil.error("UpdateCampaign", e, context);
        } finally {
            connection.close();
            connection = null;
        }
    }

    public void delete(Integer id){
        SQLiteDatabase connection = null;
        try {
            SqliteConnection sqlite = new SqliteConnection(context);
            connection = sqlite.getWritableDatabase();
            CampaignDAO dao = new CampaignDAO(connection);
            dao.delete(id);
        } catch(Exception e) {
            LoggingUtil.error("DeleteCampaign", e, context);
        } finally {
            connection.close();
            connection = null;
        }
    }
}
