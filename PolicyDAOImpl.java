package com.insurance.dao;

import com.insurance.dao.model.Policy;
import com.insurance.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PolicyDAOImpl implements PolicyDAO {

    @Override
    public boolean addPolicy(Policy policy) {
        String query = "INSERT INTO policies (holdername, policytype, premium, expirydate) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, policy.getHolderName());
            ps.setString(2, policy.getPolicyType());
            ps.setDouble(3, policy.getPremium());
            ps.setDate(4, policy.getExpiryDate());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Policy> getAllPolicies() {
        List<Policy> policies = new ArrayList<>();
        String query = "SELECT * FROM policies";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                policies.add(new Policy(
                    rs.getInt("policyid"), rs.getString("holdername"),
                    rs.getString("policytype"), rs.getDouble("premium"),
                    rs.getDate("expirydate")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return policies;
    }

    @Override
    public Policy getPolicyById(int policyId) {
        String query = "SELECT * FROM policies WHERE policyid = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, policyId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Policy(rs.getInt("policyid"), rs.getString("holdername"),
                        rs.getString("policytype"), rs.getDouble("premium"), rs.getDate("expirydate"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        String query = "UPDATE policies SET holdername=?, policytype=?, premium=?, expirydate=? WHERE policyid=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, policy.getHolderName());
            ps.setString(2, policy.getPolicyType());
            ps.setDouble(3, policy.getPremium());
            ps.setDate(4, policy.getExpiryDate());
            ps.setInt(5, policy.getPolicyId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    @Override
    public boolean deletePolicy(int policyId) {
        String query = "DELETE FROM policies WHERE policyid=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, policyId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}