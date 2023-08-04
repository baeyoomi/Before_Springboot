package com.example.test.repository;

import com.example.test.entity.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassBoardRepositoty {
    public List<Board> findAllByPage(int page, int size) throws SQLException {

        // jdbc connection 객체 가져오기
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://database-1.comsexdn4ejr.ap-northeast-2.rds.amazonaws.com/indexdb", "admin", "ay2111!!");

            // jdbc statement 객체 생성
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM board ORDER BY no DESC LIMIT :size OFFSET :size * (:page - 1)");
            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, page);

            // 쿼리 실행
            ResultSet resultSet = preparedStatement.executeQuery();

            // 결과 리스트
            List<Board> boards = new ArrayList<>();

            // 결과 탐색
            while (resultSet.next()) {
                Board board = new Board();
                board.setNo((int) resultSet.getLong("no"));
                board.setTitle(resultSet.getString("title"));
                board.setContent(resultSet.getString("content"));
                board.setCreatedAt(resultSet.getTimestamp("createdAt"));
                board.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
                boards.add(board);
            }

            // 결과 반환
            return boards;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
