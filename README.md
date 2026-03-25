✅ 全体方針：テーマは「シンプルな掲示板」
以下の要件を必ず満たすようにします。

DAO … DBアクセスの分離
Bean … データを詰めるクラス
セッション（ログイン） … ログイン機能
フォワード … JSP に画面表示
リダイレクト … Post/Redirect/Get
インクルード … ヘッダ・フッタ共通化

画面は以下の4画面を実装するとシンプルで要件が満たせます。

✅ 必要な画面一覧（最少構成）



画面内容1. ログイン画面 (login.jsp)ユーザーID/パスワード入力2. 掲示板一覧 (board.jsp)投稿一覧表示 + 投稿フォーム3. 投稿完了用（リダイレクトのみ）投稿後に /BoardServlet へリダイレクト4. エラー画面 (error.jsp)エラーを表示
ヘッダ/フッタは include で共通化
header.jsp, footer.jsp を作成（include）。

✅ 画面遷移図（文字版）
[login.jsp]
     | (POST /LoginServlet)
     v
  LoginServlet
     |-- 成功 --> (session に user 保存 → forward) --> board.jsp
     |
     |-- 失敗 --> error.jsp

[board.jsp]
     | (POST /PostServlet)
     v
  PostServlet
     |-- DB登録
     |-- redirect --> /BoardServlet  (PRGパターン)

[BoardServlet]
     |-- 投稿一覧取得（DAO）
     |-- forward --> board.jsp


✅ ファイル構成（初学者向け・最適化済み）
/WebContent
    /WEB-INF
        web.xml
    /jsp
        login.jsp
        board.jsp
        error.jsp
        header.jsp
        footer.jsp
/database （任意：SQLなど）
/src
    /model
        UserBean.java
        PostBean.java
    /dao
        UserDAO.java
        PostDAO.java
    /servlet
        LoginServlet.java
        BoardServlet.java
        PostServlet.java


✅ データベース構造（超シンプル）
■ users テーブル



カラム型説明idINT PKauto incrementuser_idVARCHARログインIDpasswordVARCHARパスワード（平文でOK：授業なら）
■ posts テーブル



カラム型説明idINT PKauto incrementuser_idVARCHAR投稿者IDtextVARCHAR本文created_atDATETIME投稿日

✅ 役割分担（6名チーム向け）
授業時間が限られているので、初回で役割を固定すると効率が上がります。



役割人数内容① 画面担当（JSP）2名login.jsp, board.jsp, error.jsp, include部品② サーブレット担当2名LoginServlet, BoardServlet, PostServlet③ DAO/Bean/DB担当2名テーブル作成, DAOクラス, Beanクラス

✅ データフロー（投稿の場合）
board.jsp（投稿フォーム）
        |
        | POST text="○○"
        v
PostServlet
        | 1. request.getParameter("text")
        | 2. セッションから user を取得
        | 3. DAO を使って DB INSERT
        |
        | 4. redirect -> /BoardServlet
        v
BoardServlet
        | 1. DAOで投稿一覧を取得
        | 2. request.setAttribute("posts", list)
        |
        | forward
        v
board.jsp に一覧表示

✅ 授業5コマでの開発スケジュール例
■ 1コマ目：設計 & Eclipse/Tomcat環境構築

プロジェクト作成（Dynamic Web Project）
パッケージ構造作成（servlet, dao, model）
画面設計、DB設計

■ 2コマ目：ログイン機能

users テーブル作成
UserDAO → LoginServlet → login.jsp
セッション保存

■ 3コマ目：掲示板一覧表示

PostDAO の findAll()
BoardServlet → board.jsp

■ 4コマ目：投稿機能（PRGパターン）

PostServlet（INSERT）
redirect → BoardServlet

■ 5コマ目：動作確認 & プレゼン準備

エラー処理追加
CSSで最低限の見た目
発表準備
