package ls.example.server;

import ls.example.service.document.DocumentService;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.ServerCapabilities;
import org.eclipse.lsp4j.TextDocumentSyncKind;
import org.eclipse.lsp4j.services.TextDocumentService;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class LanguageServerImpl implements ExampleLanguageServer
{
    private final DocumentService documentService;
    private final WorkspaceService workspaceService;

    @Autowired
    public LanguageServerImpl(DocumentService documentService, WorkspaceService workspaceService)
    {
        this.documentService = documentService;
        this.workspaceService = workspaceService;
    }

    @Override
    public CompletableFuture<InitializeResult> initialize(InitializeParams params)
    {
        return CompletableFuture.completedFuture(new InitializeResult(createServerCapabilities()));
    }

    @Override
    public CompletableFuture<Object> shutdown()
    {
        return CompletableFuture.supplyAsync(() -> 0);
    }

    @Override
    public void exit()
    {
        System.exit(0);
    }

    @Override
    public TextDocumentService getTextDocumentService()
    {
        return documentService;
    }

    @Override
    public WorkspaceService getWorkspaceService()
    {
        return workspaceService;
    }

    private ServerCapabilities createServerCapabilities()
    {
        ServerCapabilities serverCapabilities = new ServerCapabilities();
        serverCapabilities.setTextDocumentSync(TextDocumentSyncKind.Full);

        serverCapabilities.setHoverProvider(true);

        return serverCapabilities;
    }
}
