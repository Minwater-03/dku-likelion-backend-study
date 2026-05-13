public class BankAccount {
    int bankCode;
    int accountNo;
    String owner;
    int balance;
    boolean isDormant;
    int password;

    // 메소드
    void inquiry(){
    }
    void deposit(){}
    void withdraw(){}
    void helpInDormant(){
    }

    // 생성자
    // 클래스 내부에 정의, 생성자 메서드 명은 클래스
    // new 연산자와 함께 사용
    BankAccount(    int bankCode,
                    int accountNo,
                    String owner,
                    int balance,
                    int password,
                    boolean isdormant
    ){
        this.bankCode = bankCode;
        this.accountNo = accountNo;
        this.owner = owner;
        this.balance = balance;
    }
}
