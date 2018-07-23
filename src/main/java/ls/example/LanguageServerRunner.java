package ls.example;

import ls.example.server.ExampleLanguageServer;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LanguageServerRunner implements CommandLineRunner
{
    private final ExampleLanguageServer languageServer;

    @Autowired
    public LanguageServerRunner(ExampleLanguageServer languageServer)
    {
        this.languageServer = languageServer;
    }

    @Override
    public void run(String... args)
    {
        startServer();
    }

    private void startServer()
    {
        Launcher<LanguageClient> launcher = LSPLauncher.createServerLauncher(languageServer, System.in, System.out);
//        LanguageClient client = launcher.getRemoteProxy();
//        ((LanguageClientAware)languageServer).connect(client);
        launcher.startListening();
    }
}