import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class JewelleryWebsite {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {
            String page = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Golden Touch Jewellery</title>
                    <style>
                        * { box-sizing: border-box; }
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: #101010;
                            color: #f8f2e6;
                        }
                        header {
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                            padding: 20px 8%;
                            background: #050505;
                            border-bottom: 1px solid #b99748;
                        }
                        .logo {
                            color: #e2c16c;
                            font-size: 23px;
                            font-weight: bold;
                            letter-spacing: 2px;
                        }
                        nav a {
                            color: #f8f2e6;
                            text-decoration: none;
                            margin-left: 20px;
                            font-size: 14px;
                        }
                        nav a:hover { color: #e2c16c; }
                        .hero {
                            text-align: center;
                            padding: 85px 20px;
                            background: linear-gradient(135deg, #332719, #111 70%);
                        }
                        .hero h1 {
                            color: #e2c16c;
                            font-size: clamp(32px, 5vw, 54px);
                            margin: 0 0 15px;
                        }
                        .hero p {
                            color: #ddd2bd;
                            font-size: 17px;
                            margin-bottom: 25px;
                        }
                        .button {
                            display: inline-block;
                            padding: 12px 25px;
                            background: #c9a34d;
                            color: #111;
                            text-decoration: none;
                            font-weight: bold;
                            border-radius: 3px;
                        }
                        .collection {
                            padding: 50px 8%;
                            text-align: center;
                        }
                        .collection h2 {
                            color: #e2c16c;
                            font-size: 29px;
                            margin-bottom: 28px;
                        }
                        .products {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(190px, 1fr));
                            gap: 20px;
                        }
                        .product {
                            padding: 25px 18px;
                            background: #1c1c1c;
                            border: 1px solid #6d572b;
                            border-radius: 6px;
                        }
                        .jewel {
                            height: 125px;
                            display: grid;
                            place-items: center;
                            margin-bottom: 15px;
                            border-radius: 5px;
                            background: radial-gradient(circle, #574321, #171717 70%);
                            color: #f0d27e;
                            font-size: 66px;
                        }
                        .product h3 { color: #f0d27e; }
                        .product p { color: #c9c0b1; font-size: 14px; }
                        footer {
                            padding: 22px;
                            text-align: center;
                            background: #050505;
                            border-top: 1px solid #6d572b;
                            color: #c9c0b1;
                            font-size: 13px;
                        }
                        @media (max-width: 560px) {
                            header { flex-direction: column; gap: 14px; }
                            nav a { margin: 0 8px; }
                        }
                    </style>
                </head>
                <body>
                    <header>
                        <div class="logo">GOLDEN TOUCH</div>
                        <nav>
                            <a href="#home">Home</a>
                            <a href="#collection">Collection</a>
                            <a href="#contact">Contact</a>
                        </nav>
                    </header>

                    <section class="hero" id="home">
                        <h1>Elegance in Every Detail</h1>
                        <p>Discover beautiful jewellery for every occasion.</p>
                        <a class="button" href="#collection">View Collection</a>
                    </section>

                    <section class="collection" id="collection">
                        <h2>Our Jewellery Collection</h2>
                        <div class="products">
                            <div class="product">
                                <div class="jewel">◇</div>
                                <h3>Gold Rings</h3>
                                <p>Elegant designs for every occasion.</p>
                            </div>
                            <div class="product">
                                <div class="jewel">✧</div>
                                <h3>Necklaces</h3>
                                <p>Beautiful pieces to complete your look.</p>
                            </div>
                            <div class="product">
                                <div class="jewel">⌁</div>
                                <h3>Bracelets</h3>
                                <p>Simple and stylish accessories.</p>
                            </div>
                            <div class="product">
                                <div class="jewel">✦</div>
                                <h3>Earrings</h3>
                                <p>Classic pieces with a golden touch.</p>
                            </div>
                        </div>
                    </section>

                    <footer id="contact">
                        <p>Contact: hello@goldentouch.com</p>
                        <p>&copy; 2026 Golden Touch Jewellery</p>
                    </footer>
                </body>
                </html>
                """;

            byte[] response = page.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.length);
            try (OutputStream output = exchange.getResponseBody()) {
                output.write(response);
            }
        });

        server.start();
        System.out.println("Open http://localhost:8080 in your browser.");
    }
}
