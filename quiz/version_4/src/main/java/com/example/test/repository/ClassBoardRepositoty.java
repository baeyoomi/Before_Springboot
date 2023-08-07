package com.example.test.repository;

import com.example.test.entity.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassBoardRepositoty {

    private static final String JDBC_URL = "jdbc:mariadb://database-1.comsexdn4ejr.ap-northeast-2.rds.amazonaws.com/indexdb";
    private static final String JDBC_USERNAME = "admin";
    private static final String JDBC_PASSWORD = "ay2111!!";

    public List<Board> findAllByPage(int page, int size) throws SQLException {

        // jdbc connection 객체 가져오기
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);

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
            board.setNumber((long) resultSet.getLong("number"));
            board.setTitles(resultSet.getString("titles"));
            board.setContent(resultSet.getString("content"));
            board.setCreatedAt(resultSet.getTimestamp("createdAt"));
            board.setUpdatedAt(resultSet.getTimestamp("updatedAt"));
            boards.add(board);
        }

        // 결과 반환
        return boards;
    }
}
