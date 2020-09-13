**【t4j-boot】**

# ■概要

## これ is 何？

神ライブラリである `twitter4j` を使った趣味ツール。  
以前、単独の pure java で実装してたんだけど、これまた神FWである `SpringBoot` を使ってリライトしたもの。

## ざっくりいうと

twitter4j と SpringBoot でなんか色々やりたい事を詰め込んだ **ごった煮** みたいなツール。

ちなみにこれは単独のツールではなく、  
**Ubuntu(WSL)からcronで叩いてファイルに保存** したり、  
そこからまた **C#で作った別なツール** で色々してたり、  
ちょっとした **ツール群を構成する一部** であります。

## SpringBootといえば

[SpringBootに入門する為の助走本 - Qiita](https://qiita.com/sugaryo/items/5695bfcc21365f429767)


# ■ざっくり変更履歴

## TweetList

`application.properties` にJSON文字列として定義してたが、  
`src/resource/data/tweet.json` に変更してconfig系クラスも修正した。

外部定義データをjsonで置いとくパターンとして助走本Tipsに追記したい。

# ■このあとやりたい改良メモ

- いわゆるfeatureリスト
    - メッセージがリテラルベタ書きなのでどうにかしたい。
    - API機能をキックする簡単な機能画面を追加したい。
    - readme自体ももうちょっと真面目に書きたい。
    - gmailでメール飛ばす何かの機能も作りたい。


