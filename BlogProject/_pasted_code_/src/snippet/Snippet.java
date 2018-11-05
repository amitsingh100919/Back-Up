package snippet;

public class Snippet {
	.theme-explorer .file-preview .table {
	    margin: 0;
	}
	
	.theme-explorer .explorer-frame td {
	    vertical-align: middle;
	    text-align: left;
	}
	
	.explorer-frame .file-preview-text {
	    display: inline-block;
	    color: #428bca;
	    border: 1px solid #ddd;
	    font-family: Menlo, Monaco, Consolas, "Courier New", monospace;
	    outline: none;
	    padding: 8px;
	    resize: none;
	}
	
	.explorer-frame .file-preview-html {
	    display: inline-block;
	    border: 1px solid #ddd;
	    padding: 8px;
	    overflow: auto;
	}
	
	.explorer-frame .file-preview-other {
	    text-align: center;
	}
	
	.explorer-frame .file-other-icon {
	    font-size: 4.2em;
	}
	
	.theme-explorer .explorer-frame .kv-file-content {
	    width: 80px;
	    height: 80px;
	    padding: 5px;
	    text-align: center;
	}
	
	.theme-explorer .file-actions-cell {
	    width: 100px;
	    padding: 0;
	}
	
	.theme-explorer .file-thumb-progress .progress {
	    display: block;
	    margin-top: 5px;
	}
	
	.theme-explorer .file-thumb-progress .progress, .theme-explorer .file-thumb-progress .progress-bar {
	    height: 13px;
	    font-size: 11px;
	    line-height: 13px;
	}
	
	.theme-explorer .file-actions-cell {
	    position: relative;
	}
	
	.theme-explorer .file-upload-indicator, .theme-explorer .file-drag-handle {
	    position: absolute;
	    text-align: center;
	    top: 0;
	    right: 0;
	    padding-left: 5px;
	    padding-right: 2px;
	    border-right: none;
	    border-top: none;
	    border-left: 1px solid #8a6d3b;
	    border-bottom: 1px solid #8a6d3b;
	    border-bottom-left-radius: 11px;
	    font-size: 12px;
	}
	
	.theme-explorer .explorer-caption {
	    display: block;
	    color: #777;
	}
	
	.theme-explorer .file-actions {
	    text-align: center;
	}
	
	.theme-explorer .kvsortable-ghost {
	    opacity: 0.6;
	    background: #e1edf7;
	    border: 2px solid #a1abff;
	}
	
	@media only screen and (max-device-width: 500px) {
	    .theme-explorer .file-upload-indicator, .theme-explorer .file-drag-handle {
	        border-radius: 0;
	        border: 1px solid #8a6d3b;
	        margin-bottom: 5px;
	    }
	
	    .theme-explorer .explorer-caption {
	        display: block;
	        white-space: nowrap;
	        overflow: hidden;
	        text-overflow: ellipsis;
	        width: 160px;
	        text-align: left;
	        color: #777;
	    }
	}
	
	.theme-explorer .file-upload-indicator {
	    font-size: 13px;
	    padding-left: 6px;
	    background-color: #fcf8e3;
	    border-color: #faebcc;
	}
	
	.theme-explorer .file-drag-handle {
	    right: -2px;
	    background-color: #d9edf7;
	    border-color: #bce8f1;
	}
	
	.theme-explorer .file-preview-error .file-upload-indicator {
	    background-color: #f2dede;
	    border-color: #ebccd1;
	}
	
	.theme-explorer .file-preview-success .file-upload-indicator {
	    background-color: #dff0d8;
	    border-color: #d6e9c6;
	}
	
	.theme-explorer .file-preview-loading .file-upload-indicator {
	    background-color: #e5e5e5;
	    border-color: #777;
	}
}

