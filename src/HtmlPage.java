public class HtmlPage implements Page {

    @Override
    public String build() {
        return """
                <!DOCTYPE html>
                <html lang="tr">
                    <head>
                        <meta charset="UTF-8">
                        <title> Final Değerlendirme Ödevim</title>

                        <style>
                            body {
                                background-color: #c98a9b;
                                font-family: Verdana, sans-serif;
                                margin: 0;
                                padding: 60px 20px;
                            }
                            .kutu {
                                background-color: #ffffff;
                                max-width: 560px;
                                margin: 0 auto;
                                padding: 40px 48px;
                                border-radius: 16px;
                                border-top: 8px solid #8e3b52;
                            }
                            h1 {
                                font-family: Georgia, serif;
                                font-size: 44px;
                                color: #8e3b52;
                                margin: 0 0 8px 0;
                            }
                            h2 {
                                font-size: 20px;
                                font-weight: normal;
                                color: #6b7280;
                                margin: 0 0 24px 0;
                            }
                            p {
                                font-size: 18px;
                                line-height: 1.7;
                                color: #374151;
                                font-style: italic;
                                margin: 0;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="kutu">
                            <h1> Ayşe Yılmaz</h1>
                            <h2> Öğrenci Numaram = 5250505062 </h2>
                            <p> Merhaba, ben <b>Ayşe</b>. Kırklareli Üniversitesinde Yazılım Mühendisliği 2. sınıf öğrencisiyim. Kendimi geliştirmeyi , yeni şeyler öğrenmeyi ve kitap okumayı seviyorum. Bölümden mezun olduğumda otomasyon alanına yönelmeyi hedefliyorum.</p>
                        </div>
                    </body>
                </html>
                """;
    }
}