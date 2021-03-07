package br.com.rafaelfaustini.srpg.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import br.com.rafaelfaustini.srpg.entity.Campaign;
import br.com.rafaelfaustini.srpg.interfaces.IDao;
import br.com.rafaelfaustini.srpg.util.SqliteConnection;

public class CampaignDAO implements IDao <Integer, Campaign> {

    private SQLiteDatabase db;

    public CampaignDAO(SQLiteDatabase db) {
        this.db = db;
    }

    @Override
    public Campaign get(Integer id) throws Exception {
        String sql = "SELECT name, story from campaign where id = ?";
        String[] params = new String[]{ id.toString() };
        Cursor cursor = db.rawQuery(
                sql,
                params);
        if (cursor.moveToNext()) {
            Campaign campaign = new Campaign(id, cursor.getString(0), cursor.getString(1));
            return campaign;
        }

        return null;
    }

    @Override
    public List<Campaign> getAll() throws Exception {
        List<Campaign> campaigns = new ArrayList<Campaign>();
        String sql = "SELECT id, name, story from campaign";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Campaign campaign = new Campaign(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            campaigns.add(campaign);
        }

        return campaigns;
    }

    @Override
    public void insert(Campaign c) throws Exception {
        ContentValues values = new ContentValues();
        values.put("name", c.getName());
        values.put("story", c.getStory());
        db.insert("campaign", null, values);
    }

    @Override
    public void update(Campaign c) throws Exception {
        String whereClause = "id=?";
        ContentValues values = new ContentValues();
        values.put("name", c.getName());
        values.put("story", c.getStory());
        String[] whereArgs = new String[] { String.valueOf(c.getId()) };
        db.update("campaign", values, whereClause, whereArgs);
    }

    @Override
    public void delete(Integer id) throws Exception {
        String whereClause = "id=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        db.delete("campaign", whereClause, whereArgs);
    }
}
