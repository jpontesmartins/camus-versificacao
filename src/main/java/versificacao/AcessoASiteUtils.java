package versificacao;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class AcessoASiteUtils {

	private static final String C_TESTE_PAGE3_TXT = "C:\\teste\\page3.txt";

	
	public static InputStream getPagina(String link) throws Exception {
		URLConnection connection = AcessoASiteUtils.acessarOLink(link);
		return (InputStream) connection.getContent();
	}
	
	
	public static URLConnection acessarOLink(String link)
			throws NoSuchAlgorithmException, KeyManagementException, MalformedURLException, IOException {

		final TrustManager[] trustAllCerts = regrasDeConfianca();
		SSLContext sslContext = SSLContext.getInstance("SSL");
		sslContext.init(null, trustAllCerts, null);
		outraVerificacaoDeSeguranca(sslContext);

		URL url = new URL(link);
		URLConnection connection = url.openConnection();
		return connection;
	}

	public static TrustManager[] regrasDeConfianca() {
		final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(final X509Certificate[] chain, final String authType) {
			}

			@Override
			public void checkServerTrusted(final X509Certificate[] chain, final String authType) {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		} };
		return trustAllCerts;
	}

	public static void outraVerificacaoDeSeguranca(SSLContext sslContext) {
		HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		});

		Authenticator.setDefault(new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("", "".toCharArray());
			}
		});
	}

	public static void acessarOSiteECriarOArquivo(InputStream codigoFonteDaPagina)
			throws IOException, FileNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = codigoFonteDaPagina.read(buffer)) != -1) {
			baos.write(buffer, 0, length);
		}

		FileOutputStream fos = new FileOutputStream(new File(C_TESTE_PAGE3_TXT));
		baos.writeTo(fos);
	}

	public static String acessarAPagina(String linkCompleto) throws SAXException, IOException, Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document doc = builder.parse(Escansao.getPagina(linkCompleto));
		doc.getElementsByTagName("title");
//		xmlStringBuilder.append("<?xml version="1.0"?> <class> </class>");
//		ByteArrayInputStream input =  new ByteArrayInputStream(
//		   xmlStringBuilder.toString().getBytes("UTF-8"));
//		Document doc = builder.parse(input);
		
		
		return "";

	}

}
