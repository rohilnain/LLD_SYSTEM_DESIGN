package Questions;

import java.awt.*;
import java.util.List;

public class ChessGame {
    private ChessBoard chessBoard;
    private List<Player> players;
    private Player CurrentPlayer;
    private GameStatus gameStatus;
    ChessGame(ChessBoard chessBoard,List<Player>Players){
        chessBoard=new ChessBoard();
        this.players=players;
    }
    public void startGame( ){

    }
    public void ChangeTurn(Player player){

    }
    public void checkGameStatus(){

    }
}
enum GameStatus{
    ONGOING,FORFEITED,DRAWN,WON
}
class ChessBoard{
    private int [][]chessBoard=new int [8][8];

    public int[][] updateChessboard(Move move){

    }
    public int[][] getChessBoard(){
        return chessBoard;
    }
}

class Account{
    String userName;
    String password;
    String nickName;
}
class Player extends Account{
    private Color color;
    private int playerId;
    private int playerRating;
    private VerifyMove verifyMove;
    public Color getPlayerColor(){
        return this.color;
    }
    public void makeMove(ChessBoard chessBoard,Move move){
        //verify move

    }
}
class Move{
    Piece piece;
    Color color;
    Position from;
    Position to;
    Boolean isCastling;
    Boolean isEnPassant;
    Boolean isPromotion;

}
class Position{
    int posx;
    int posy;
}
class Piece{
    PieceType pieceType;
    Position Piece;
    PieceStatus pieceStatus;
    ValidPieceMove validMoves;
    List<Position>showValidMoves(ChessBoard chessBoard){

    }
}
enum PieceType{
    PAWN,KING,QUEEN,ROOK,BISHOP,KNIGHT
}
enum PieceStatus{
    KILLED,ACTIVE
}
class VerifyMove{
    ValidPieceMove validPieceMove;
    Boolean isMoveCorrect(ChessBoard chessBoard,Move move){

    }
}

class ValidPieceMove{
    PiecePossibleMovesFactory piecePossibleMovesFactory;
    List<Position>getValidPieceMoves(ChessBoard chessBoard,Piece piece){

    }
}
//Simple factory to tell how each chess piece move
interface PiecePossibleMoves{
    List<Position>ChessPieceMovementByRules(ChessBoard currentChessBoard,Position from,Position to);
}

class PawnPossibleMoves implements PiecePossibleMoves{

    public List<Position>ChessPieceMovementByRules(ChessBoard chessBoard,Position from,Position to){
        //Pawn Move calculation
        //one step, initial 2 step, en passant, kill move
    }
}

class KingPossibleMoves implements PiecePossibleMoves{

    public List<Position>ChessPieceMovementByRules(ChessBoard chessBoard,Position from,Position to){
        //King Move calculation
        //one step in all direction...check for blockage and check positions
        //if none moves left then checkmated
    }
}
class QueenPossibleMoves implements PiecePossibleMoves{

    public List<Position>ChessPieceMovementByRules(ChessBoard chessBoard,Position from,Position to){
        //Pawn Move calculation
        //can move virtually in any direction
        //check for blocking postions
    }
}
class RookPossibleMoves implements PiecePossibleMoves{

    public List<Position>ChessPieceMovementByRules(ChessBoard chessBoard,Position from,Position to){
        //Pawn Move calculation
        //Can Move Horizontal and vertical direction any places
        //check for blocking piece
    }
}
class BishopPossibleMoves implements PiecePossibleMoves{

    public List<Position>ChessPieceMovementByRules(ChessBoard chessBoard,Position from,Position to){
        //Pawn Move calculation
        //Can Move Horizontal directions of its color
        //check for blocking piece
    }
}
class KnightPossibleMoves implements PiecePossibleMoves{

    public List<Position>ChessPieceMovementByRules(ChessBoard chessBoard,Position from,Position to){
        //Pawn Move calculation
        //one step, initial 2 step, en passant, kill move
        //move Diagonal adjacent opposite color square in a L fashion
    }
}

class PiecePossibleMovesFactory{
    PiecePossibleMovesFactory(ChessBoard chessBoard,Position from,Position to,PieceType pieceType){
        if(PieceType.PAWN==pieceType){
            return new PawnPossibleMoves(chessBoard, from, to);
        }
        //similarily for others pieces
    }
}